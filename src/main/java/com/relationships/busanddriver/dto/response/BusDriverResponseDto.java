package com.relationships.busanddriver.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusDriverResponseDto {
    Long busDriverId;
    String driverName;
    String driverSurname;
    List<BusResponseDto> buses;
}
