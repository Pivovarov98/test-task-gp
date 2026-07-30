package org.example.testtaskgp.dto.hotel.search;

import org.example.testtaskgp.entity.enums.Amenities;

import java.util.List;

public record HotelSearchFilter(
        String name,
        String brand,
        String city,
        String country,
        List<Amenities> amenities) {}
