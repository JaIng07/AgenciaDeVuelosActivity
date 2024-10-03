package com.booking.bookingservice.mappers;

import com.booking.bookingservice.dtos.BookingDto;
import com.booking.bookingservice.entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper( BookingMapper.class );

    @Mapping(source = "flightNumber", target = "booking")
    BookingDto BookingToBookingDto(Booking booking);
}
