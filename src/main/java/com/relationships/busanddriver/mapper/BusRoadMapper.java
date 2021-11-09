package com.relationships.busanddriver.mapper;

import com.relationships.busanddriver.dao.entity.BusRoad;
import com.relationships.busanddriver.dto.request.BusRoadRequestDto;
import com.relationships.busanddriver.dto.response.BusRoadResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BusMapper.class})
public interface BusRoadMapper {
    List<BusRoadResponseDto> busRoadsToResponse(List<BusRoad> busRoads);

    BusRoadResponseDto busRoadToResponse(BusRoad busRoad);

    BusRoad requestToBusRoad(BusRoadRequestDto busRoadRequestDto);
}
