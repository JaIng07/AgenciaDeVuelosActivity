package com.bookingService.bookingMicroService.mappers;

import com.bookingService.bookingMicroService.dtos.BookingDto;
import com.bookingService.bookingMicroService.dtos.BookingToSaveDto;
import com.bookingService.bookingMicroService.entities.Booking;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper( BookingMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "flightNumber", target = "flightNumber"),
            @Mapping(source = "passengerName", target = "passengerName")
    })
    BookingDto bookingEntityToBookingDto(Booking booking);

    @InheritInverseConfiguration
    Booking bookingDtoToBookingEntity(BookingDto bookingDto);

    @Mappings({
            @Mapping(source = "flightNumber", target = "flightNumber"),
            @Mapping(source = "passengerName", target = "passengerName")
    })
    BookingToSaveDto bookingEntityToBookingToSaveDto(Booking booking);

    @InheritInverseConfiguration
    Booking bookingToSaveDtoToBookingEntity(BookingToSaveDto bookingToSaveDto);
}
