package com.relationships.busanddriver.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long busId;
    String busModel;
    String manufacturer;
    Integer seatCount;
    boolean hasElectricEngine;

    @OneToOne(cascade = CascadeType.ALL)
    BusRoad busRoad;

    @ManyToOne
    @JoinColumn(name = "busGarageId", referencedColumnName = "busGarageId")
    BusGarage busGarage;

    @JsonIgnore
    @ManyToMany(mappedBy = "buses")
    List<BusDriver> busDrivers;

}
