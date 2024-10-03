package com.booking.flightservice.dtos;

import java.util.UUID;

public record FlightToShowDto(
        UUID id,
        String flightNumber,
        String origin,
        String destination,
        String departureTime
) {
}
