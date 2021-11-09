package com.relationships.busanddriver.controller;

import com.relationships.busanddriver.dto.request.BusRequestDto;
import com.relationships.busanddriver.dto.response.BusResponseDto;
import com.relationships.busanddriver.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses/")
@RequiredArgsConstructor
public class BusController {
    private final BusService busService;

    @GetMapping
    public List<BusResponseDto> allBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("{busId}")
    public BusResponseDto getBus(@PathVariable Long busId) {
        return busService.getBus(busId);
    }

    @PostMapping
    public long saveNewBus(@RequestBody BusRequestDto busRequestDto) {
        return busService.saveNewBus(busRequestDto);
    }

    @DeleteMapping("{busId}")
    public void deleteBus(@PathVariable Long busId) {
        busService.deleteBusById(busId);
    }

   /* @PutMapping("{busId}/busdrivers/{driverId}")
    public BusResponseDto addDriverToBus(@PathVariable Long busId,
                                         @PathVariable Long driverId) {
        return busService.assignBusDriver(busId, driverId);
    }*/
}
