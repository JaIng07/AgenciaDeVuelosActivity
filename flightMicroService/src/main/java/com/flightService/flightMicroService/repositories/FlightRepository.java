package com.flightService.flightMicroService.repositories;

import com.flightService.flightMicroService.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {

    Optional<Flight> findById(UUID id);
    Optional<Flight> deleteFlightById(UUID id);

    //Query Methods

    //Simples
    List<Flight> findByflightNumber(String flightNumber);
    List<Flight> findByOrigin(String origin);
    List<Flight> findBydestination(String destination);
    List<Flight> findBydepartureTime(String departureTime);

    //Compuestos
    List<Flight> findByFlightNumberAndOrigin(String flightNumber, String origin);
}
