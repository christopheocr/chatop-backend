package com.chatop.backend.service;


import com.chatop.backend.dto.CreateRentalDto;
import com.chatop.backend.dto.RentalDto;
import com.chatop.backend.dto.RentalSummaryDto;
import com.chatop.backend.dto.UpdateRentalDto;
import com.chatop.backend.entity.Rental;
import com.chatop.backend.repository.RentalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final UserService userService;
    private static final String UPLOAD_DIR = "uploads/";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public RentalService(RentalRepository rentalRepository, UserService userService) {
        this.rentalRepository = rentalRepository;
        this.userService = userService;
    }

    public List<RentalSummaryDto> getAllRentals() {
        return rentalRepository.findAll().stream()
                .map(this::convertToRentalSummaryDto) // Utilise RentalSummaryDto ici
                .collect(Collectors.toList());
    }

    public Optional<RentalDto> getRentalById(int id) {
        return rentalRepository.findById(id)
                .map(this::convertToRentalDto);
    }

    private RentalDto convertToRentalDto(Rental rental) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        List<String> pictureUrls = rental.getPicture() != null
                ? Collections.singletonList(baseUrl + "/uploads/" + rental.getPicture())
                : Collections.emptyList();

        return new RentalDto(
                rental.getId(),
                rental.getName(),
                rental.getSurface(),
                rental.getPrice(),
                pictureUrls,
                rental.getDescription(),
                rental.getOwnerId(),
                rental.getCreatedAt().format(DATE_FORMATTER),
                rental.getUpdatedAt().format(DATE_FORMATTER)
        );
    }

    private RentalSummaryDto convertToRentalSummaryDto(Rental rental) {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String pictureUrl = rental.getPicture() != null
                ? baseUrl + "/uploads/" + rental.getPicture()
                : null;

        return new RentalSummaryDto(
                rental.getId(),
                rental.getName(),
                rental.getSurface(),
                rental.getPrice(),
                pictureUrl,
                rental.getDescription(),
                rental.getOwnerId(),
                rental.getCreatedAt().format(DATE_FORMATTER),
                rental.getUpdatedAt().format(DATE_FORMATTER)
        );
    }

    public Rental createRental(CreateRentalDto rentalDto) throws IOException {
        String fileName = null;
        if (rentalDto.getPicture() != null && !rentalDto.getPicture().isEmpty()) {
            fileName = saveFile(rentalDto.getPicture());
        }
        Rental rental = convertToRental(rentalDto, fileName);
        return rentalRepository.save(rental);
    }

    private String saveFile(MultipartFile file) throws IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Path.of(UPLOAD_DIR, fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    public Rental convertToRental(CreateRentalDto rentalDto, String fileName) {
        Rental rental = new Rental();
        rental.setName(rentalDto.getName());
        rental.setSurface(rentalDto.getSurface());
        rental.setPrice(rentalDto.getPrice());
        rental.setDescription(rentalDto.getDescription());
        rental.setPicture(fileName);
        rental.setOwner(userService.getCurrentUser());
        rental.setCreatedAt(LocalDateTime.now());
        rental.setUpdatedAt(LocalDateTime.now());
        return rental;
    }

    public void updateRental(int id, UpdateRentalDto rentalDto) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rental not found"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int currentUserId = ((com.chatop.backend.entity.User) authentication.getPrincipal()).getId();
        if (rental.getOwnerId() != currentUserId) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not allowed to modify this rental");
        }

        if (rentalDto.getName() != null) rental.setName(rentalDto.getName());
        if (rentalDto.getSurface() != null) rental.setSurface(rentalDto.getSurface());
        if (rentalDto.getPrice() != null) rental.setPrice(rentalDto.getPrice());
        if (rentalDto.getDescription() != null) rental.setDescription(rentalDto.getDescription());

        rental.setUpdatedAt(LocalDateTime.now());

        rentalRepository.save(rental);
    }
}
