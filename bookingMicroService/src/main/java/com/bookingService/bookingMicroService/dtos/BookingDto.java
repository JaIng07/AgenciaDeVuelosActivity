package com.bookingService.bookingMicroService.dtos;

import java.util.UUID;

public record BookingDto(
        UUID id,
        String flightNumber,
        String passengerName
) {
}
