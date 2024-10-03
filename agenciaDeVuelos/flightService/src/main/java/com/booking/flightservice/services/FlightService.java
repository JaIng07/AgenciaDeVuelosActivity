package com.booking.flightservice.services;

import com.booking.flightservice.dtos.FlightToSaveDto;
import com.booking.flightservice.dtos.FlightToShowDto;

import java.util.List;
import java.util.UUID;

public interface FlightService {
    FlightToShowDto saveFlight(FlightToSaveDto flight);
    FlightToShowDto updateFlight(UUID id, FlightToSaveDto flight);
    FlightToShowDto findFlightById(UUID id);
    List<FlightToShowDto> findAllFlights();
    void deleteFlight(UUID id);
}
