package com.booking.bookingservice.services;

import com.booking.bookingservice.dtos.BookingToSaveDto;
import com.booking.bookingservice.dtos.BookingToShowDto;
import com.booking.bookingservice.mappers.BookingMapper;
import com.booking.bookingservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingToShowDto saveBooking(BookingToSaveDto booking) {
        return null;
    }

    @Override
    public BookingToShowDto updateBooking(UUID id, BookingToSaveDto booking) {
        return null;
    }

    @Override
    public BookingToShowDto findBookingById(UUID id) {
        return null;
    }

    @Override
    public List<BookingToShowDto> findAllBookings() {
        return List.of();
    }

    @Override
    public void deleteBooking(UUID id) {

    }
}
