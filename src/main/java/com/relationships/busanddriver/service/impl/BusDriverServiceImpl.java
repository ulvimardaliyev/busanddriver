package com.relationships.busanddriver.service.impl;

import com.relationships.busanddriver.dao.entity.Bus;
import com.relationships.busanddriver.dao.entity.BusDriver;
import com.relationships.busanddriver.dao.repository.BusDriverRepository;
import com.relationships.busanddriver.dao.repository.BusRepository;
import com.relationships.busanddriver.dto.request.BusDriverRequestDto;
import com.relationships.busanddriver.dto.response.BusDriverResponseDto;
import com.relationships.busanddriver.mapper.BusDriverMapper;
import com.relationships.busanddriver.mapper.BusMapper;
import com.relationships.busanddriver.service.BusDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusDriverServiceImpl implements BusDriverService {

    private final BusDriverRepository busDriverRepository;
    private final BusDriverMapper busDriverMapper;
    private final BusMapper busMapper;
    private final BusRepository busRepository;

    @Override
    public List<BusDriverResponseDto> getAllBusDrivers() {
        List<BusDriver> allBusDrivers = busDriverRepository.findAll();
        return busDriverMapper.allBusDriversToResponse(allBusDrivers);
    }

    @Override
    public BusDriverResponseDto getBusDriverById(Long busDriverId) {
        BusDriver busDriver = busDriverRepository.findBusDriverByBusDriverId(busDriverId);
        return busDriverMapper.busDriverToResponse(busDriver);
    }

    @Transactional
    @Override
    public void deleteBusDriverById(Long busDriverId) {
        busDriverRepository.deleteBusDriverByBusDriverId(busDriverId);
    }

    @Transactional
    @Override
    public long saveNewBusDriver(BusDriverRequestDto busDriverRequestDto) {
        BusDriver currentBusDriver = busDriverMapper.requestToEntity(busDriverRequestDto);
        return busDriverRepository.save(currentBusDriver).getBusDriverId();
    }

    @Transactional
    @Override
    public BusDriverResponseDto addBusToBusDriver(Long busDriverId, Long busId) {
        BusDriver currentBusDriver = busDriverRepository.findBusDriverByBusDriverId(busDriverId);
        Bus currentBus = busRepository.findBusByBusId(busId);
        currentBusDriver.getBuses().add(currentBus);
        BusDriver busDriver = busDriverRepository.save(currentBusDriver);
        return busDriverMapper.busDriverToResponse(busDriver);
    }

    @Override
    public BusDriverResponseDto updateBusDriver(Long busDriverId,
                                                BusDriverRequestDto busDriverRequest) {
        BusDriver currentBusDriver = busDriverRepository.findBusDriverByBusDriverId(busDriverId);
        BusDriver updatedBusDriver =
                busDriverMapper.updateBusDriver(busDriverRequest, currentBusDriver);
        return busDriverMapper.busDriverToResponse(busDriverRepository.save(updatedBusDriver));
    }
}
