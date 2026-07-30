package org.example.testtaskgp.dto.hotel.create_update;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record ArrivalTimeDTO(
        @NotNull
        @JsonFormat(pattern = "HH:mm")
        LocalTime checkIn,

        @NotNull
        @JsonFormat(pattern = "HH:mm")
        LocalTime checkOut
) {
}
