package org.example.testtaskgp.dto.hotel.create_update;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank
        String houseNumber,

        @NotBlank
        String street,

        @NotBlank
        String city,

        @NotBlank
        String country,

        @NotBlank
        Integer postCode
) {
}
