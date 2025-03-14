package com.chatop.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objet contenant les informations de connexion d'un utilisateur.")
public class LoginUserDto {
    @Schema(description = "Adresse email de l'utilisateur", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Mot de passe de l'utilisateur", example = "Test!123")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
