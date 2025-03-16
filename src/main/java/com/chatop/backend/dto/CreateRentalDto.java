package com.chatop.backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Schema(description = "Objet contenant les informations nécessaires pour créer une nouvelle location.")
public class CreateRentalDto extends BaseRentalDto{

    @Schema(description = "Image de la location (fichier).", type = "string", format = "binary")
    private MultipartFile picture;

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

}
