package com.bookingService.bookingMicroService.dtos;

public record BookingToSaveDto(
        String flightNumber,
        String passengerName
) {
}
