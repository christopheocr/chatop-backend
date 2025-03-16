package com.chatop.backend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Résumé d'une location, utilisé pour lister les locations disponibles.")
public class RentalSummaryDto extends BaseRentalDto{
    @Schema(description = "Identifiant unique de la location.", example = "1")
    private int id;

    @Schema(description = "URL de l'image de la location.", example = "https://example.com/image.jpg")
    private String picture;


    @Schema(description = "Identifiant du propriétaire de la location.", example = "1")
    @JsonProperty("owner_id")
    private int ownerId;

    @Schema(description = "Date de création de la location.", example = "2012/12/02")
    @JsonProperty("created_at")
    private String createdAt;

    @Schema(description = "Date de dernière mise à jour de la location.", example = "2014/12/02")
    @JsonProperty("updated_at")
    private String updatedAt;

    public RentalSummaryDto(int id, String name, BigDecimal surface, BigDecimal price, String picture, String description, int ownerId, String createdAt, String updatedAt) {
        super(name, surface, price, description);
        this.id = id;
        this.picture = picture;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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
