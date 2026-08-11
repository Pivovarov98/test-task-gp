package org.example.testtaskgp.dto.hotel.response;

import lombok.Builder;
import org.example.testtaskgp.entity.Address;
import org.example.testtaskgp.entity.ArrivalTime;
import org.example.testtaskgp.entity.Contacts;

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
