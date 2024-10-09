package com.flightService.flightMicroService.services;

import com.flightService.flightMicroService.dtos.FlightDto;
import com.flightService.flightMicroService.dtos.FlightToSaveDto;

import java.util.List;
import java.util.UUID;

public interface FlightService {
    FlightDto saveFlight(FlightToSaveDto flight);
    FlightDto updateFlight(UUID id, FlightToSaveDto flight);
    FlightDto findFlightById(UUID id);
    List<FlightDto> findAllFlights();
    void deleteFlight(UUID id);
}
