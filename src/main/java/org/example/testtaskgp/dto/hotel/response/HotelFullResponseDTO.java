package org.example.testtaskgp.dto.hotel.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.example.testtaskgp.entity.Address;
import org.example.testtaskgp.entity.ArrivalTime;
import org.example.testtaskgp.entity.Contacts;
import org.example.testtaskgp.entity.enums.Amenities;
import org.example.testtaskgp.entity.enums.Brand;

import java.util.List;

@Builder
public record HotelFullResponseDTO(
        Long id,
        String name,
        String description,
        String brand,
        Address address,
        Contacts contacts,
        ArrivalTime arrivalTime,
        List<String> amenities
) {
}
