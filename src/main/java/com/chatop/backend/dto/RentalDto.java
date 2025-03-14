package com.chatop.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Données détaillées d'une location, incluant l'URL complète de l'image et les informations du propriétaire.")
public class RentalDto {

    @Schema(description = "Identifiant unique de la location.", example = "1")
    private int id;

    @Schema(description = "Nom de la location.", example = "Dream House")
    private String name;

    @Schema(description = "Surface en m².", example = "24")
    private BigDecimal surface;

    @Schema(description = "Prix en euros.", example = "30")
    private BigDecimal price;

    @Schema(description = "URL(s) complète(s) de l'image de la location.", example = "[\"https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg\"]")
    private List<String> picture;

    @Schema(description = "Description de la location.", example = "Lorem ipsum dolor sit amet, consectetur adipiscing elit...")
    private String description;

    @Schema(description = "Identifiant du propriétaire de la location.", example = "1")
    @JsonProperty("owner_id")
    private int ownerId;

    @Schema(description = "Date de création de la location.", example = "2012/12/02")
    @JsonProperty("created_at")
    private String createdAt;

    @Schema(description = "Date de dernière mise à jour de la location.", example = "2014/12/02")
    @JsonProperty("updated_at")
    private String updatedAt;

    public RentalDto(int id, String name, BigDecimal surface, BigDecimal price, List<String> picture, String description, int ownerId, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.surface = surface;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getSurface() { return surface; }
    public void setSurface(BigDecimal surface) { this.surface = surface; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public List<String> getPicture() { return picture; }
    public void setPicture(List<String> picture) { this.picture = picture; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
