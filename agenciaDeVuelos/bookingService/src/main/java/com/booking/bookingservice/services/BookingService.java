package com.booking.bookingservice.services;

import com.booking.bookingservice.dtos.BookingToSaveDto;
import com.booking.bookingservice.dtos.BookingToShowDto;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingToShowDto saveBooking(BookingToSaveDto booking);
    BookingToShowDto updateBooking(UUID id, BookingToSaveDto booking);
    BookingToShowDto findBookingById(UUID id);
    List<BookingToShowDto> findAllBookings();
    void deleteBooking(UUID id);
}
