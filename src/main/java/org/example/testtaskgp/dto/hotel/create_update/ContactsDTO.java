package org.example.testtaskgp.dto.hotel.create_update;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ContactsDTO(
        @NotBlank
        String phone,

        @Email
        @NotBlank
        String email
) {
}
