package org.example.testtaskgp.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.example.testtaskgp.exception.UnknownBrandNameException;

import java.util.Arrays;

public enum Brand {
    MARRIOTT("Marriott International"),
    JIN_JIANG("Jin Jiang International"),
    HILTON("Hilton Worldwide"),
    INTER_CONTINENTAL("InterContinental Hotel Group"),
    WYNDHAM("Wyndham Hotels & Resorts");

    private final String brandName;

    Brand(String brandName) {
        this.brandName = brandName;
    }

    @JsonValue
    public String getBrandName() {
        return brandName;
    }

    @JsonCreator
    public static Brand fromBrandName(String brandName) {
        return Arrays.stream(values())
                .filter(b -> b.brandName.equalsIgnoreCase(brandName))
                .findFirst()
                .orElseThrow(() -> new UnknownBrandNameException("Unknown brand: " + brandName));
    }
}
