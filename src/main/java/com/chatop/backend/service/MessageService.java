package com.chatop.backend.service;


import com.chatop.backend.dto.CreateMessageDto;
import com.chatop.backend.entity.Message;
import com.chatop.backend.entity.Rental;
import com.chatop.backend.entity.User;
import com.chatop.backend.repository.MessageRepository;
import com.chatop.backend.repository.RentalRepository;
import com.chatop.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;


    public MessageService(MessageRepository messageRepository,RentalRepository rentalRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
    }


    public void save(CreateMessageDto messagePostDto) {

        User user = userRepository.findById(messagePostDto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));


        Rental rental = rentalRepository.findById(messagePostDto.getRentalId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rental not found"));


        Message message = new Message();
        message.setUser(user);
        message.setRental(rental);
        message.setMessage(messagePostDto.getMessage());
        message.setCreatedAt(LocalDateTime.now());

        messageRepository.save(message);
    }
}
