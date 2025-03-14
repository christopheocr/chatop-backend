package com.chatop.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Représente les informations d'un utilisateur retournées par l'API.")
public class UserInfoDto {
    @Schema(
            description = "Identifiant unique de l'utilisateur",
            example = "1"
    )
    private Integer id;

    @Schema(
            description = "Nom complet de l'utilisateur",
            example = "John Doe"
    )
    private String name;

    @Schema(
            description = "Adresse email de l'utilisateur",
            example = "john.doe@example.com"
    )
    private String email;

    @JsonProperty("created_at")
    @Schema(
            description = "Date de création du compte utilisateur",
            example = "2024/03/13"
    )
    private String createdAt;

    @JsonProperty("updated_at")
    @Schema(
            description = "Date de dernière mise à jour du compte utilisateur",
            example = "2024/03/14"
    )
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
