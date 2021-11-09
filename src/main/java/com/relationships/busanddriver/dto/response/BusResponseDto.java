package com.relationships.busanddriver.dto.response;

import com.relationships.busanddriver.dao.entity.BusDriver;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusResponseDto {
    Long busId;
    String busModel;
    String manufacturer;
    int seatCount;
    boolean hasElectricEngine;
    BusRoadResponseDto busRoad;
    BusGarageResponseDto busGarage;
    List<BusDriver> busDrivers;
}
