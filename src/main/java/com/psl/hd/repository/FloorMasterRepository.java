package com.psl.hd.repository;

import com.psl.hd.model.BuildingMaster;
import com.psl.hd.model.FloorMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FloorMasterRepository extends JpaRepository<FloorMaster, Integer> {
    List<FloorMaster> findByBuildingid(BuildingMaster buildingid);

}
