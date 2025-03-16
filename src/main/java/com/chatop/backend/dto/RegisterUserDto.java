package com.chatop.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Objet contenant les informations nécessaires à l'inscription d'un utilisateur.")
public class RegisterUserDto extends BaseUserDto{


    @Schema(description = "Nom complet de l'utilisateur", example = "John Doe")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
