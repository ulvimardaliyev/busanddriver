package com.relationships.busanddriver.controller;

import com.relationships.busanddriver.dto.request.BusDriverRequestDto;
import com.relationships.busanddriver.dto.response.BusDriverResponseDto;
import com.relationships.busanddriver.service.BusDriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/busdrivers/")
@RequiredArgsConstructor
public class BusDriverController {

    private final BusDriverService busDriverService;

    @GetMapping
    public List<BusDriverResponseDto> getAllBusDrivers() {
        return busDriverService.getAllBusDrivers();
    }

    @GetMapping("{busDriverId}")
    public BusDriverResponseDto getBusDriverById(@PathVariable long busDriverId) {
        return busDriverService.getBusDriverById(busDriverId);
    }

    @DeleteMapping("{busDriverId}")
    public void deleteBusDriver(@PathVariable long busDriverId) {
        busDriverService.deleteBusDriverById(busDriverId);
    }

    @PostMapping
    public long newDriver(@RequestBody BusDriverRequestDto busDriverRequestDto) {
        return busDriverService.saveNewBusDriver(busDriverRequestDto);
    }

    //TODO write PUT Method
    @PutMapping("{busDriverId}/buses/{busId}")
    public BusDriverResponseDto addBusToBusDriver(@PathVariable Long busDriverId,
                                                  @PathVariable Long busId) {
        return busDriverService.addBusToBusDriver(busDriverId, busId);
    }
}
