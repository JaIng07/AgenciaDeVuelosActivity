package com.bookingService.bookingMicroService.services;

import com.bookingService.bookingMicroService.dtos.BookingDto;
import com.bookingService.bookingMicroService.dtos.BookingToSaveDto;
import com.bookingService.bookingMicroService.entities.Booking;
import com.bookingService.bookingMicroService.exception.BookingNotFoundException;
import com.bookingService.bookingMicroService.mappers.BookingMapper;
import com.bookingService.bookingMicroService.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingDto saveBooking(BookingToSaveDto booking) {
        Booking bookingToSave = BookingMapper.INSTANCE.bookingToSaveDtoToBookingEntity(booking);
        Booking bookingSaved = bookingRepository.save(bookingToSave);
        return BookingMapper.INSTANCE.bookingEntityToBookingDto(bookingSaved);
    }

    @Override
    public BookingDto updateBooking(UUID id, BookingToSaveDto booking) {
        Optional<Booking> bookingConsultado = bookingRepository.findById(id);

        if (bookingConsultado.isEmpty())
            throw new BookingNotFoundException("Booking con ID " + id + " no encontrado");

        Booking book = bookingConsultado.get();

        if (book.getId() != null) book.setId(book.getId());
        if (book.getFlightNumber() != null) book.setFlightNumber(book.getFlightNumber());
        if (book.getPassengerName() != null) book.setPassengerName(book.getPassengerName());

        Booking updatedBooking = bookingRepository.save(book);

        return BookingMapper.INSTANCE.bookingEntityToBookingDto(updatedBooking);
    }

    @Override
    public BookingDto findBookingById(UUID id) throws BookingNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);

        if (booking.isEmpty())
            throw new BookingNotFoundException("Booking con ID " + id + "no encontrado");

        return BookingMapper.INSTANCE.bookingEntityToBookingDto(booking.get());
    }

    @Override
    public List<BookingDto> findAllBookings() {
        return List.of();
    }

    @Override
    public void deleteBooking(UUID id) {
        Optional<Booking> bookingToDelete = bookingRepository.findById(id);

        if (bookingToDelete.isEmpty())
            throw new BookingNotFoundException("Booking con ID " + id + " no existe");

        bookingRepository.deleteById(id);
    }
}
