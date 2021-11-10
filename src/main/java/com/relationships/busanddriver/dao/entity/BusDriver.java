package com.relationships.busanddriver.dao.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class BusDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long busDriverId;
    String driverName;
    String driverSurname;

    @ManyToMany
    @JoinTable(name = "bus_busdriver",
            joinColumns = @JoinColumn(name = "busDriverId", referencedColumnName = "busDriverId"),
            inverseJoinColumns = @JoinColumn(name = "busId", referencedColumnName = "busId")
    )
    List<Bus> buses;
}
