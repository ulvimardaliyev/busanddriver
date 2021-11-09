package com.relationships.busanddriver.dao.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "busId")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long busId;
    String busModel;
    String manufacturer;
    int seatCount;
    boolean hasElectricEngine;

    @OneToOne(cascade = CascadeType.ALL)
    BusRoad busRoad;

    @ManyToOne
    @JoinColumn(name = "busGarageId", referencedColumnName = "busGarageId")
    BusGarage busGarage;

    @ManyToMany(mappedBy = "buses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<BusDriver> busDrivers;
   /* @PreRemove
    private void removeBusFromDriver() {
        busDrivers.forEach(busDriver -> busDriver.getBuses().clear());
    }*/
}
