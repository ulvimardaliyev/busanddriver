package com.relationships.busanddriver.service.impl;

import com.relationships.busanddriver.dao.entity.BusRoad;
import com.relationships.busanddriver.dao.repository.BusRoadRepository;
import com.relationships.busanddriver.dto.request.BusRoadRequestDto;
import com.relationships.busanddriver.dto.response.BusRoadResponseDto;
import com.relationships.busanddriver.mapper.BusRoadMapper;
import com.relationships.busanddriver.service.BusRoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusRoadServiceImpl implements BusRoadService {

    private final BusRoadRepository busRoadRepository;
    private final BusRoadMapper busRoadMapper;

    @Override
    public List<BusRoadResponseDto> getAllBusRoads() {
        List<BusRoad> busRoads = busRoadRepository.findAll();
        return busRoadMapper.busRoadsToResponse(busRoads);
    }

    @Override
    public BusRoadResponseDto getBusRoadById(Long busRoadId) {
        BusRoad currentBusRoad = busRoadRepository.findBusRoadByRoadId(busRoadId);
        return busRoadMapper.busRoadToResponse(currentBusRoad);
    }

    @Transactional
    @Override
    public void deleteBusRoad(Long busRoadId) {
        busRoadRepository.deleteBusRoadByRoadId(busRoadId);
    }

    @Transactional
    @Override
    public long saveNewBusRoad(BusRoadRequestDto busRoadRequestDto) {
        BusRoad busRoad = busRoadMapper.requestToBusRoad(busRoadRequestDto);
        return busRoadRepository.save(busRoad).getRoadId();
    }
}
