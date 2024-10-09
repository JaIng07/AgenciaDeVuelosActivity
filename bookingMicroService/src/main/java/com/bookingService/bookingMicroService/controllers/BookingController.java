package com.bookingService.bookingMicroService.controllers;

import com.bookingService.bookingMicroService.dtos.BookingDto;
import com.bookingService.bookingMicroService.dtos.BookingToSaveDto;
import com.bookingService.bookingMicroService.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping()
    public ResponseEntity<BookingDto> saveBooking(@RequestBody BookingToSaveDto booking) {
        return ResponseEntity.ok(bookingService.saveBooking(booking));
    }


    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable("id") UUID id, @RequestBody BookingToSaveDto booking) {
        return ResponseEntity.ok(bookingService.updateBooking(id, booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable UUID id) {
        return ResponseEntity.ok(bookingService.findBookingById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable UUID id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
