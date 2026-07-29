package org.example.testtaskgp.entity.enums;

import lombok.Getter;

@Getter
public enum Brand {
    MARRIOTT("Marriott International"),
    JIN_JIANG("Jin Jiang International"),
    HILTON("Hilton Worldwide"),
    INTER_CONTINENTAL("InterContinental Hotel Group"),
    WYNDHAM("Wyndham Hotels & Resorts");

    private final String brand;

    Brand(String brand){
        this.brand = brand;
    }
}
