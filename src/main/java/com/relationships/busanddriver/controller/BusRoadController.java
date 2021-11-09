package com.relationships.busanddriver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/busroads/")
@RequiredArgsConstructor
public class BusRoadController {

   /* private final BusRoadService busRoadService;

    @GetMapping
    public List<BusRoadResponseDto> getAllBusRoads() {
        return busRoadService.getAllBusRoads();
    }

    @GetMapping("{busRoadId}")
    public BusRoadResponseDto getBusRoad(@PathVariable Long busRoadId) {
        return busRoadService.getBusRoadById(busRoadId);
    }

    @PostMapping
    public long saveNewBusRoad(@RequestBody BusRoadRequestDto busRoadRequestDto) {
        return busRoadService.saveNewBusRoad(busRoadRequestDto);
    }

    @DeleteMapping("{busRoadId}")
    public void deleteBusRoad(@PathVariable Long busRoadId) {
        busRoadService.deleteBusRoad(busRoadId);
    }*/
}
