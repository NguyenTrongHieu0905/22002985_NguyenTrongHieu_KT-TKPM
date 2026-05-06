package com.iuh.fit.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookingRequest {

    @NotNull(message = "userId is required")
    private Long userId;

    private String username;

    @NotNull(message = "movieId is required")
    private Long movieId;

    private String movieTitle;

    @NotNull(message = "numberOfSeats is required")
    @Min(value = 1, message = "Must book at least 1 seat")
    private Integer numberOfSeats;

    private Double pricePerSeat;
}
