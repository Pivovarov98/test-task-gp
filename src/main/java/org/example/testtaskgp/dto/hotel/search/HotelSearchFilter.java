package org.example.testtaskgp.dto.hotel.search;

import java.util.List;

public record HotelSearchFilter(
        String name,
        String brand,
        String city,
        String country,
        List<String> amenities) {}
