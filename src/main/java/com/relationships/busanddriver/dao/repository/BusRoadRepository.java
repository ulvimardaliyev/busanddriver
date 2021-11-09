package com.relationships.busanddriver.dao.repository;

import com.relationships.busanddriver.dao.entity.BusRoad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRoadRepository extends CrudRepository<BusRoad, Long> {

    List<BusRoad> findAll();

    BusRoad findBusRoadByRoadId(Long busRoadId);

    void deleteBusRoadByRoadId(Long aLong);
}
