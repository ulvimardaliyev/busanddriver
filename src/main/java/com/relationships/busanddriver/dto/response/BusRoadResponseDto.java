package com.relationships.busanddriver.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusRoadResponseDto {
    Long roadId;
    String startPoint;
    String endPoint;
    double roadLength;
}
