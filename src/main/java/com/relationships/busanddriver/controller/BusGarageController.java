package com.relationships.busanddriver.controller;

import com.relationships.busanddriver.dto.request.BusGarageRequestDto;
import com.relationships.busanddriver.dto.response.BusGarageResponseDto;
import com.relationships.busanddriver.service.BusGarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/busgarages/")
@RequiredArgsConstructor
public class BusGarageController {

    private final BusGarageService busGarageService;

    @GetMapping
    List<BusGarageResponseDto> getAllBusGarages() {
        return busGarageService.getAllBusGarage();
    }

    @GetMapping("{busGarageId}")
    public BusGarageResponseDto getBusGarage(@PathVariable Long busGarageId) {
        return busGarageService.getBusGarage(busGarageId);
    }

    @PostMapping
    public long saveNewBusGarage(@RequestBody BusGarageRequestDto busGarageRequestDto) {
        return busGarageService.saveBusGarage(busGarageRequestDto);
    }

    @DeleteMapping("{busGarageId}")
    void deleteBusGarage(@PathVariable Long busGarageId) {
        busGarageService.deleteBusGarageById(busGarageId);
    }
}
