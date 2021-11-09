package com.relationships.busanddriver.dao.repository;

import com.relationships.busanddriver.dao.entity.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {
    @Override
    List<Bus> findAll();

    Bus findBusByBusId(Long busId);

    void deleteBusByBusId(Long aLong);

}
