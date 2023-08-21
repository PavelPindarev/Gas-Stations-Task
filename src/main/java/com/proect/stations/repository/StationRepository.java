package com.proect.stations.repository;

import com.proect.stations.model.entity.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, UUID> {

    @Query("select s.e5 from StationEntity s")
    List<Double> findAllE5();

    @Query("select s.e10 from StationEntity s")
    List<Double> findAllE10();

    @Query("select s.diesel from StationEntity s")
    List<Double> findAllDiesel();

    List<StationEntity> findAllByName(String stationName);
}
