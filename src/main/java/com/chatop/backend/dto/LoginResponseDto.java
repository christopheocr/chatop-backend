package com.chatop.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Réponse contenant le token JWT après l'authentification d'un utilisateur.")
public class LoginResponseDto {
    @Schema(
            description = "Jeton JWT à utiliser pour l'authentification des requêtes",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    )
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
