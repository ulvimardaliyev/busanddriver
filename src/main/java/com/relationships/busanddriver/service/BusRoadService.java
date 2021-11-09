package com.relationships.busanddriver.service;

import com.relationships.busanddriver.dto.request.BusRoadRequestDto;
import com.relationships.busanddriver.dto.response.BusRoadResponseDto;

import java.util.List;

public interface BusRoadService {
    List<BusRoadResponseDto> getAllBusRoads();

    BusRoadResponseDto getBusRoadById(Long busRoadId);

    void deleteBusRoad(Long busRoadId);

    long saveNewBusRoad(BusRoadRequestDto busRoadRequestDto);
}
