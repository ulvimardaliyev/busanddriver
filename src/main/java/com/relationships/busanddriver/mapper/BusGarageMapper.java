package com.relationships.busanddriver.mapper;

import com.relationships.busanddriver.dao.entity.BusGarage;
import com.relationships.busanddriver.dto.request.BusGarageRequestDto;
import com.relationships.busanddriver.dto.response.BusGarageResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusGarageMapper {
    List<BusGarageResponseDto> busGaragesToResponse(List<BusGarage> busGarages);

    BusGarageResponseDto busGaragesToResponse(BusGarage busGarage);

    BusGarage busGarageRequestToBusGarage(BusGarageRequestDto busGarageRequestDto);
}
