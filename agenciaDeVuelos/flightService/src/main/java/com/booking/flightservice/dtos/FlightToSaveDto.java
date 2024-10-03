package com.booking.flightservice.dtos;

import java.util.UUID;

public record FlightToSaveDto(
        String flightNumber,
        String origin,
        String destination,
        String departureTime
) {
}
