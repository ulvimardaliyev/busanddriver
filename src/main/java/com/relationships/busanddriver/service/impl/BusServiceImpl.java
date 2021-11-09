package com.relationships.busanddriver.service.impl;

import com.relationships.busanddriver.dao.entity.Bus;
import com.relationships.busanddriver.dao.entity.BusDriver;
import com.relationships.busanddriver.dao.entity.BusGarage;
import com.relationships.busanddriver.dao.repository.BusDriverRepository;
import com.relationships.busanddriver.dao.repository.BusGarageRepository;
import com.relationships.busanddriver.dao.repository.BusRepository;
import com.relationships.busanddriver.dto.request.BusRequestDto;
import com.relationships.busanddriver.dto.response.BusGarageResponseDto;
import com.relationships.busanddriver.dto.response.BusResponseDto;
import com.relationships.busanddriver.mapper.BusDriverMapper;
import com.relationships.busanddriver.mapper.BusGarageMapper;
import com.relationships.busanddriver.mapper.BusMapper;
import com.relationships.busanddriver.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusServiceImpl implements BusService {
    private final BusDriverRepository busDriverRepository;
    private final BusDriverMapper busDriverMapper;
    private final BusRepository busRepository;
    private final BusMapper busMapper;
    private final BusGarageRepository busGarageRepository;
    private final BusGarageMapper busGarageMapper;

    @Override
    public List<BusResponseDto> getAllBuses() {
        List<Bus> allBuses = busRepository.findAll();
        return busMapper.allBusToResponse(allBuses);
    }

    @Override
    public BusResponseDto getBus(Long busId) {
        Bus currentBus = busRepository.findBusByBusId(busId);
        BusGarageResponseDto busGarageResponseDto =
                busGarageMapper.busGaragesToResponse(currentBus.getBusGarage());
        return busMapper.busToResponse(currentBus, busGarageResponseDto);
    }

    @Transactional
    @Override
    public void deleteBusById(Long busId) {
        busRepository.deleteBusByBusId(busId);
    }

    @Transactional
    @Override
    public long saveNewBus(BusRequestDto busRequestDto) {
        BusGarage currentBusGarage =
                busGarageRepository.findBusGarageByBusGarageId(busRequestDto.getBusGarageId());
        Bus bus = busMapper.requestToBus(busRequestDto, currentBusGarage);
        return busRepository.save(bus).getBusId();
    }

    @Transactional
    @Override
    public BusResponseDto assignBusDriver(Long busId, Long driverId) {
        Bus currentBus = busRepository.findBusByBusId(busId);
        BusDriver currentBusDriver = busDriverRepository.findBusDriverByBusDriverId(driverId);
        currentBus.getBusDrivers().add(currentBusDriver);
        Bus bus = busRepository.save(currentBus);
        return busMapper.busToResponseWithUpdatedDrivers(bus);
    }

}
