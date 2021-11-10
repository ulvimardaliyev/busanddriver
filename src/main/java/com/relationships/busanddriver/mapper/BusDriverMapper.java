package com.relationships.busanddriver.mapper;

import com.relationships.busanddriver.dao.entity.BusDriver;
import com.relationships.busanddriver.dto.request.BusDriverRequestDto;
import com.relationships.busanddriver.dto.response.BusDriverResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                BusMapper.class
        }
)
public interface BusDriverMapper {

    List<BusDriverResponseDto> allBusDriversToResponse(List<BusDriver> busDrivers);

    BusDriverResponseDto busDriverToResponse(BusDriver busDriver);

    BusDriver requestToEntity(BusDriverRequestDto busDriverRequestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BusDriver updateBusDriver(BusDriverRequestDto busDriverRequest,
                              @MappingTarget BusDriver driver);
}
