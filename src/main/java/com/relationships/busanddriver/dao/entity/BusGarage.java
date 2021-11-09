package com.relationships.busanddriver.dao.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "busGarageId")
public class BusGarage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long busGarageId;
    double busGarageArea;
    @JsonIgnore
    @OneToMany(mappedBy = "busGarage", cascade = CascadeType.ALL)
    List<Bus> bus;
}
