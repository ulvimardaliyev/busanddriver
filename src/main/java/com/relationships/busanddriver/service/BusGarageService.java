package com.relationships.busanddriver.service;

import com.relationships.busanddriver.dto.request.BusGarageRequestDto;
import com.relationships.busanddriver.dto.response.BusGarageResponseDto;

import java.util.List;

public interface BusGarageService {
    List<BusGarageResponseDto> getAllBusGarage();

    BusGarageResponseDto getBusGarage(Long busGarageId);

    void deleteBusGarageById(Long busGarageId);

    long saveBusGarage(BusGarageRequestDto busGarageRequestDto);
}
