package org.example.testtaskgp.dto.hotel.create_update;

import jakarta.validation.constraints.NotEmpty;
import org.example.testtaskgp.entity.enums.Amenities;

import java.util.List;

public record AmenitiesDTO(
        @NotEmpty
        List<Amenities> amenities
) {
}
