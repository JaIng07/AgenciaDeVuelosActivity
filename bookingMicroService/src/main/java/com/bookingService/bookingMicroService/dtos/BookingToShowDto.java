package com.bookingService.bookingMicroService.dtos;

import java.util.UUID;

public record BookingToShowDto(
        UUID id,
        String flightNumber,
        String passengerName
) {
}
