package com.chatop.backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Réponse contenant la liste des locations disponibles.")
public class RentalListResponseDto {
    @Schema(description = "Liste des locations disponibles.")
    private List<RentalSummaryDto> rentals;

    public RentalListResponseDto(List<RentalSummaryDto> rentals) {
        this.rentals = rentals;
    }

    public List<RentalSummaryDto> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalSummaryDto> rentals) {
        this.rentals = rentals;
    }
}
