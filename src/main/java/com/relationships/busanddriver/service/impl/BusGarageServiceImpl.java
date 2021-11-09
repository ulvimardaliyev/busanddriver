package com.relationships.busanddriver.service.impl;

import com.relationships.busanddriver.dao.entity.BusGarage;
import com.relationships.busanddriver.dao.repository.BusGarageRepository;
import com.relationships.busanddriver.dto.request.BusGarageRequestDto;
import com.relationships.busanddriver.dto.response.BusGarageResponseDto;
import com.relationships.busanddriver.mapper.BusGarageMapper;
import com.relationships.busanddriver.service.BusGarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusGarageServiceImpl implements BusGarageService {

    private final BusGarageRepository busGarageRepository;
    private final BusGarageMapper busGarageMapper;

    @Override
    public List<BusGarageResponseDto> getAllBusGarage() {
        List<BusGarage> allBusGarages = busGarageRepository.findAll();
        return busGarageMapper.busGaragesToResponse(allBusGarages);
    }

    @Override
    public BusGarageResponseDto getBusGarage(Long busGarageId) {
        BusGarage currentBusGarage =
                busGarageRepository.findBusGarageByBusGarageId(busGarageId);
        return busGarageMapper.busGaragesToResponse(currentBusGarage);
    }

    @Transactional
    @Override
    public void deleteBusGarageById(Long busGarageId) {
        busGarageRepository.deleteBusGarageByBusGarageId(busGarageId);
    }

    @Override
    public long saveBusGarage(BusGarageRequestDto busGarageRequestDto) {
        BusGarage busGarage = busGarageMapper.busGarageRequestToBusGarage(busGarageRequestDto);
        return busGarageRepository.save(busGarage).getBusGarageId();
    }
}
