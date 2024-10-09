package com.flightService.flightMicroService.dtos;

import java.util.UUID;

public record FlightDto(
        UUID id,
        String flightNumber,
        String origin,
        String destination,
        String departureTime
        ) {

}
