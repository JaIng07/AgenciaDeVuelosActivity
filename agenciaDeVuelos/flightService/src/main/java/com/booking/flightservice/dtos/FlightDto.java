package com.booking.flightservice.dtos;

import java.util.UUID;

public record FlightDto(
        UUID id,
        String flightNumber,
        String origin,
        String destination,
        String departureTime
        ) {

}
