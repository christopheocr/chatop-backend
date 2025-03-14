package com.chatop.backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Données envoyées pour mettre à jour une location.")
public class UpdateRentalDto {
    @Schema(description = "Nom de la location.", example = "Appartement moderne")
    private String name;

    @Schema(description = "Surface en m².", example = "50")
    private BigDecimal surface;

    @Schema(description = "Prix en euros.", example = "200")
    private BigDecimal price;

    @Schema(description = "Description détaillée de la location.", example = "Un appartement spacieux et lumineux.")
    private String description;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getSurface() { return surface; }
    public void setSurface(BigDecimal surface) { this.surface = surface; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
