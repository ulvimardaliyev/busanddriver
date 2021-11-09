package com.relationships.busanddriver.service;

import com.relationships.busanddriver.dto.request.BusRequestDto;
import com.relationships.busanddriver.dto.response.BusResponseDto;

import java.util.List;

public interface BusService {
    List<BusResponseDto> getAllBuses();

    BusResponseDto getBus(Long busId);

    void deleteBusById(Long busId);

    long saveNewBus(BusRequestDto busRequestDto);

    BusResponseDto assignBusDriver(Long busId, Long driverId);

}
