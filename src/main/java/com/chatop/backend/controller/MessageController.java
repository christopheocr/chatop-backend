package com.chatop.backend.controller;

import com.chatop.backend.dto.CreateMessageDto;
import com.chatop.backend.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(
        name = "Gestion des messages",
        description = "Endpoints permettant d'envoyer des messages liés aux locations."
)
@RestController
@RequestMapping("/messages")
@SecurityRequirement(name = "BearerAuth")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Operation(
            summary = "Envoyer un message",
            description = "Permet d'envoyer un message à un propriétaire pour une location spécifique."
    )
    @PostMapping()
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody CreateMessageDto messagePostDto) {
        messageService.save(messagePostDto);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Message send with success");
        return ResponseEntity.ok(response);
    }
}
