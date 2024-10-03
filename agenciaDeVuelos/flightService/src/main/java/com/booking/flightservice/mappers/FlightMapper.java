package com.booking.flightservice.mappers;

import com.booking.flightservice.dtos.FlightDto;
import com.booking.flightservice.entities.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlightMapper {

    FlightMapper INSTANCE = Mappers.getMapper( FlightMapper.class );

    @Mapping(source = "flightNumber", target = "booking")
    FlightDto flightToFlightDto(Flight flight);
}
