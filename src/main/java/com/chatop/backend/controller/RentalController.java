package com.chatop.backend.controller;

import com.chatop.backend.dto.*;
import com.chatop.backend.entity.Rental;
import com.chatop.backend.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Tag(
        name = "Gestion des locations",
        description = "Endpoints permettant de gérer les locations (ajout, modification, récupération)."
)
@RestController
@RequestMapping("/rentals")
@SecurityRequirement(name = "BearerAuth")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Operation(
            summary = "Récupérer une location par son ID",
            description = "Retourne les détails d'une location spécifique en fonction de son identifiant."
    )
    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> getRental(@PathVariable int id) {
        Optional<RentalDto> rentalDto = rentalService.getRentalById(id);
        return rentalDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Récupérer la liste de toutes les locations disponibles",
            description = "Retourne toutes les locations sous forme de liste."
    )
    @GetMapping
    public ResponseEntity<RentalListResponseDto> getAllRentals() {
        List<RentalSummaryDto> rentals = rentalService.getAllRentals();
        return ResponseEntity.ok(new RentalListResponseDto(rentals));
    }


    @Operation(
            summary = "Créer une nouvelle location",
            description = "Permet d'ajouter une nouvelle location avec une image et des informations détaillées."
    )
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<RentalResponseDto> createRental(@ModelAttribute CreateRentalDto rentalDto) {
        try {
            rentalService.createRental(rentalDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new RentalResponseDto("Rental created successfully!"));
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "File upload failed", e);
        }
    }

    @Operation(
            summary = "Met à jour une location existante",
            description = "Modifie les informations d'une location existante. Seul le propriétaire peut mettre à jour la location."
    )
    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<RentalResponseDto> updateRental(@PathVariable int id, @ModelAttribute UpdateRentalDto rentalDto) {
        rentalService.updateRental(id, rentalDto);
        return ResponseEntity.ok(new RentalResponseDto("Rental updated !"));
    }
}
