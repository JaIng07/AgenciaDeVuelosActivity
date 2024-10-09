package com.flightService.flightMicroService.controllers;

import com.flightService.flightMicroService.dtos.FlightDto;
import com.flightService.flightMicroService.dtos.FlightToSaveDto;
import com.flightService.flightMicroService.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping()
    public ResponseEntity<FlightDto> saveFlight(@RequestBody FlightToSaveDto flight) {
        return ResponseEntity.ok(flightService.saveFlight(flight));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable("id") UUID id, @RequestBody FlightToSaveDto flight) {
        return ResponseEntity.ok(flightService.updateFlight(id, flight));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable UUID id) {
        return ResponseEntity.ok(flightService.findFlightById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable UUID id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}
