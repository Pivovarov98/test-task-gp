package org.example.testtaskgp.dto.hotel.response;

import lombok.Builder;

@Builder
public record HotelShortResponseDTO(
        Long id,
        String name,
        String description,
        String address,
        String phone) {
}
