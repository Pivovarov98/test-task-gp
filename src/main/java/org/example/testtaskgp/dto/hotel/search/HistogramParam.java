package org.example.testtaskgp.dto.hotel.search;

import org.example.testtaskgp.exception.UnknownHistogramParameterException;

import java.util.Arrays;

public enum HistogramParam {
    BRAND,
    CITY,
    COUNTRY,
    AMENITIES;

    public static HistogramParam fromValue(String value) {
        return Arrays.stream(values())
                .filter(p -> p.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new UnknownHistogramParameterException("Unknown histogram parameter: " + value));
    }
}
