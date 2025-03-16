package com.chatop.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public class BaseRentalDto {
    @Schema(description = "Nom de la location.", example = "Appartement cosy")
    private String name;

    @Schema(description = "Surface de la location en mètres carrés.", example = "50")
    private BigDecimal surface;

    @Schema(description = "Prix de la location en euros.", example = "600")
    private BigDecimal price;

    @Schema(description = "Description détaillée de la location.", example = "Lorem ipsum dolor sit amet...")
    private String description;

    public BaseRentalDto() {
    }

    public BaseRentalDto(String name, BigDecimal surface, BigDecimal price, String description) {
        this.name = name;
        this.surface = surface;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSurface() {
        return surface;
    }

    public void setSurface(BigDecimal surface) {
        this.surface = surface;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
