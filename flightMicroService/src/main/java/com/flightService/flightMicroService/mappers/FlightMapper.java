package com.flightService.flightMicroService.mappers;

import com.flightService.flightMicroService.dtos.FlightDto;
import com.flightService.flightMicroService.dtos.FlightToSaveDto;
import com.flightService.flightMicroService.entities.Flight;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FlightMapper {

    FlightMapper INSTANCE = Mappers.getMapper( FlightMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "flightNumber", target = "flightNumber"),
            @Mapping(source = "origin", target = "origin"),
            @Mapping(source = "destination", target = "destination"),
            @Mapping(source = "departureTime", target = "departureTime")
    })
    FlightDto flightEntityToFlightDto(Flight flight);

    @InheritInverseConfiguration
    Flight flightDtoToFlightEntity(FlightDto flightDto);

    @Mappings({
            @Mapping(source = "flightNumber", target = "flightNumber"),
            @Mapping(source = "origin", target = "origin"),
            @Mapping(source = "destination", target = "destination"),
            @Mapping(source = "departureTime", target = "departureTime")
    })
    FlightToSaveDto flightEntityToFlightToSaveDto(Flight flight);

    @InheritInverseConfiguration
    Flight flightToSaveDtoToFlightEntity(FlightToSaveDto flightToSaveDto);
}
