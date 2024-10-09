package com.bookingService.bookingMicroService.services;

import com.bookingService.bookingMicroService.dtos.BookingDto;
import com.bookingService.bookingMicroService.dtos.BookingToSaveDto;
import com.bookingService.bookingMicroService.dtos.BookingToShowDto;
import com.bookingService.bookingMicroService.exception.BookingNotFoundException;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingDto saveBooking(BookingToSaveDto booking);
    BookingDto updateBooking(UUID id, BookingToSaveDto booking) throws BookingNotFoundException;
    BookingDto findBookingById(UUID id) throws BookingNotFoundException;
    List<BookingDto> findAllBookings();
    void deleteBooking(UUID id) throws BookingNotFoundException;
}
