package com.relationships.busanddriver.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusRequestDto {
    String busModel;
    String manufacturer;
    int seatCount;
    boolean hasElectricEngine;
    BusRoadRequestDto busRoad;
    Long busGarageId;
}
