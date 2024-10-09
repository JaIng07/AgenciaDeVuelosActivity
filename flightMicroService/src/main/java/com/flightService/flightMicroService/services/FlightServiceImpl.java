package com.flightService.flightMicroService.services;

import com.flightService.flightMicroService.dtos.FlightDto;
import com.flightService.flightMicroService.dtos.FlightToSaveDto;
import com.flightService.flightMicroService.entities.Flight;
import com.flightService.flightMicroService.exception.FlightNotFoundException;
import com.flightService.flightMicroService.mappers.FlightMapper;
import com.flightService.flightMicroService.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightDto saveFlight(FlightToSaveDto flight) {
        Flight flightToSave = FlightMapper.INSTANCE.flightToSaveDtoToFlightEntity(flight);
        Flight flightGuardado = flightRepository.save(flightToSave);
        return FlightMapper.INSTANCE.flightEntityToFlightDto(flightGuardado);
    }

    @Override
    public FlightDto updateFlight(UUID id, FlightToSaveDto flight) {
        Optional<Flight> flightConsultado = flightRepository.findById(id);

        if (flightConsultado.isEmpty())
            throw new FlightNotFoundException("Vuelo con ID " + id + "no encontrado");

        Flight fl = flightConsultado.get();

        if (fl.getId() != null) fl.setId(fl.getId());
        if (fl.getFlightNumber() != null) fl.setFlightNumber(fl.getFlightNumber());
        if (fl.getDepartureTime() != null) fl.setDepartureTime(fl.getDepartureTime());
        if (fl.getDestination() != null) fl.setDestination(fl.getDestination());
        if (fl.getOrigin() != null) fl.setOrigin(fl.getOrigin());

        Flight updatedFlight = flightRepository.save(fl);

        return FlightMapper.INSTANCE.flightEntityToFlightDto(updatedFlight);
    }

    @Override
    public FlightDto findFlightById(UUID id) {
        Optional<Flight> flight = flightRepository.findById(id);

        if (flight.isEmpty())
            throw new FlightNotFoundException("Vuelo con ID " + id + "no encontrado");

        return FlightMapper.INSTANCE.flightEntityToFlightDto(flight.get());
    }

    @Override
    public List<FlightDto> findAllFlights() {
        return List.of();
    }

    @Override
    public void deleteFlight(UUID id) {
        Optional<Flight> flightToDelete = flightRepository.findById(id);

        if (flightToDelete.isEmpty())
            throw new FlightNotFoundException("Vuelo con ID " + id + " no existe");

        flightRepository.deleteById(id);
    }
}
