package com.relationships.busanddriver.mapper;

import com.relationships.busanddriver.dao.entity.Bus;
import com.relationships.busanddriver.dao.entity.BusGarage;
import com.relationships.busanddriver.dto.request.BusRequestDto;
import com.relationships.busanddriver.dto.response.BusGarageResponseDto;
import com.relationships.busanddriver.dto.response.BusResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusMapper {

    List<BusResponseDto> allBusToResponse(List<Bus> allBuses);

    @Mapping(target = "busGarage", source = "busGarageResponseDto")
    BusResponseDto busToResponse(Bus bus, BusGarageResponseDto busGarageResponseDto);

    @Mapping(target = "busGarage", source = "busGarage")
    Bus requestToBus(BusRequestDto busRequestDto, BusGarage busGarage);

    BusResponseDto busToResponseWithUpdatedDrivers(Bus bus);

    Bus bus(BusRequestDto busRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bus updateThisBus(BusRequestDto busRequestDto, @MappingTarget Bus bus);
}
