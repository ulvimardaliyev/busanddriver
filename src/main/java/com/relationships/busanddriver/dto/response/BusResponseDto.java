package com.relationships.busanddriver.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

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

}
