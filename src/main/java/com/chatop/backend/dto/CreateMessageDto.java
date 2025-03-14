package com.chatop.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Données pour l'envoi d'un message lié à une location.")
public class CreateMessageDto {
    @Schema(description = "Contenu du message envoyé.", example = "Bonjour, je suis intéressé par cette location.")
    private String message;

    @JsonProperty("user_id")
    @Schema(description = "Identifiant de l'utilisateur qui envoie le message.", example = "12")
    private Integer userId;

    @JsonProperty("rental_id")
    @Schema(description = "Identifiant de la location concernée par le message.", example = "45")
    private Integer rentalId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }
}
