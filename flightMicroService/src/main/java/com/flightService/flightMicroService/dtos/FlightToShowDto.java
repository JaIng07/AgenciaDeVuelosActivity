package com.flightService.flightMicroService.dtos;

import java.util.UUID;

public record FlightToShowDto(
        UUID id,
        String flightNumber,
        String origin,
        String destination,
        String departureTime
) {
}
