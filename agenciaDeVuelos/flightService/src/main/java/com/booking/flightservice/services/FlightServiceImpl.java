package com.booking.flightservice.services;

import com.booking.flightservice.dtos.FlightToSaveDto;
import com.booking.flightservice.dtos.FlightToShowDto;
import com.booking.flightservice.entities.Flight;
import com.booking.flightservice.mappers.FlightMapper;
import com.booking.flightservice.repositories.FlightRepository;
import javassist.NotFoundException;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public FlightToShowDto saveFlight(FlightToSaveDto flight) {
        Flight flightToSave = flightMapper.flightToFlightDto(flight);
        Flight flightGuardado = flightRepository.save(flightToSave);
        return flightMapper.flightToFlightDto(flightGuardado);
    }

    @Override
    public FlightToShowDto updateFlight(UUID id, FlightToSaveDto flight) {
        Optional<Flight> flightConsultado = flightRepository.findById(id);

        if (flightConsultado.isEmpty())
            throw new NotFoundException("Vuelo con ID " + id + "no encontrado");

        Flight fl =
    }

    @Override
    public FlightToShowDto findFlightById(UUID id) {
        return null;
    }

    @Override
    public List<FlightToShowDto> findAllFlights() {
        return List.of();
    }

    @Override
    public void deleteFlight(UUID id) {

    }
}
