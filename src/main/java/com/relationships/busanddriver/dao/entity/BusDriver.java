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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "busDriverId")
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

    /*@PreRemove
    private void removeBusFromDriver() {
        buses.forEach(bus-> bus.getBusDrivers().clear());
    }*/
}
