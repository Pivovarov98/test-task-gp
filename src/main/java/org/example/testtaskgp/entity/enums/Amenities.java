package org.example.testtaskgp.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.example.testtaskgp.exception.UnknownAmenitiesException;

import java.util.Arrays;

public enum Amenities {
    FREE_PARKING("Free parking"),
    FREE_WIFI("Free WiFi"),
    NON_SMOKING_ROOMS("Non-smoking rooms"),
    CONCIERGE("Concierge"),
    ON_SITE_REGISTRATION("On-site restaurant"),
    FITNESS_CENTER("Fitness center"),
    PET_FRIENDLY_ROOMS("Pet-friendly rooms"),
    ROOM_SERVICE("Room service"),
    BUSINESS_CENTER("Business center"),
    MEETING_ROOMS("Meeting rooms");

    private final String amenities;

    Amenities(String amenities) {
        this.amenities = amenities;
    }

    @JsonValue
    public String getAmenities() {
        return amenities;
    }

    @JsonCreator
    public static Amenities fromAmenities(String amenities) {
        return Arrays.stream(values())
                .filter(a -> a.amenities.equalsIgnoreCase(amenities))
                .findFirst()
                .orElseThrow(() -> new UnknownAmenitiesException("Unknown amenities: " + amenities));
    }
}
