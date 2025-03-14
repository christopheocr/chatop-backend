package com.chatop.backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Schema(description = "Objet contenant les informations nécessaires pour créer une nouvelle location.")
public class CreateRentalDto {

    @Schema(description = "Nom de la location.", example = "Appartement cosy")
    private String name;

    @Schema(description = "Surface de la location en mètres carrés.", example = "50")
    private BigDecimal surface;

    @Schema(description = "Prix de la location en euros.", example = "600")
    private BigDecimal price;

    @Schema(description = "Image de la location (fichier).", type = "string", format = "binary")
    private MultipartFile picture;

    @Schema(description = "Description détaillée de la location.", example = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
    private String description;

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

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
