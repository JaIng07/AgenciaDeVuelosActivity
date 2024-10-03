package com.booking.bookingservice.dtos;

import java.util.UUID;

public record BookingToShowDto(
        UUID id,
        String flightNumber,
        String passengerName
) {
}
