package com.booking.bookingservice.controllers;

import com.booking.bookingservice.dtos.BookingToSaveDto;
import com.booking.bookingservice.dtos.BookingToShowDto;
import com.booking.bookingservice.services.BookingService;
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
    public ResponseEntity<BookingToShowDto> saveBooking(@RequestBody BookingToSaveDto booking) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingToShowDto> updateBooking(@PathVariable("id") UUID id, @RequestBody BookingToSaveDto booking) {
        return null;
    }

    


}
