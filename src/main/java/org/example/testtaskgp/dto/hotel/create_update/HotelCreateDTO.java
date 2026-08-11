package org.example.testtaskgp.dto.hotel.create_update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HotelCreateDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        String brand,

        @Valid
        @NotNull
        AddressDTO address,

        @Valid
        @NotNull
        ContactsDTO contacts,

        @Valid
        @NotNull
        ArrivalTimeDTO arrivalTime
) {
}
