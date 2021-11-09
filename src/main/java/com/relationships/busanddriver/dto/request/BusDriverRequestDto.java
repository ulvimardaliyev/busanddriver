package com.relationships.busanddriver.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusDriverRequestDto {
    String driverName;
    String driverSurname;
}
