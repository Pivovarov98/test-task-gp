package org.example.testtaskgp.dto.hotel.create_update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.testtaskgp.entity.enums.Brand;

public record HotelCreateDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        Brand brand,

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
