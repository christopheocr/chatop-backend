package com.chatop.backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Réponse standard utilisée pour les opérations liées aux locations.")
public class RentalResponseDto {

    @Schema(description = "Message indiquant le résultat de l'opération effectuée.",
            example = "Rental created successfully! my_uploaded_image.jpg")
    private String message;

    public RentalResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
