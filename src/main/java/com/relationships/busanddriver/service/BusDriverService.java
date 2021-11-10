package com.relationships.busanddriver.service;

import com.relationships.busanddriver.dto.request.BusDriverRequestDto;
import com.relationships.busanddriver.dto.response.BusDriverResponseDto;

import java.util.List;

public interface BusDriverService {
    List<BusDriverResponseDto> getAllBusDrivers();

    BusDriverResponseDto getBusDriverById(Long busDriverId);

    void deleteBusDriverById(Long busDriverId);

    long saveNewBusDriver(BusDriverRequestDto busDriverRequestDto);

    BusDriverResponseDto addBusToBusDriver(Long busDriverId, Long busId);


    BusDriverResponseDto updateBusDriver(Long busDriverId,
                                         BusDriverRequestDto busDriverRequest);
}
