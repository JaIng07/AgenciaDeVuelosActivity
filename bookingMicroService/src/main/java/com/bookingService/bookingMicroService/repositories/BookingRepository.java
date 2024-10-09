package com.bookingService.bookingMicroService.repositories;

import com.bookingService.bookingMicroService.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {


    Optional<Booking> findById(UUID id);
    Optional<Booking> deleteBookingById(UUID id);

    //Query Methods

    //Simples
    List<Booking> findByflightNumber(String flightNumber);
    List<Booking> findBypassengerName(String passengerName);

    //Compuestos
    List<Booking> findByFlightNumberAndPassengerName(String flightNumber, String PassengerName);
}
