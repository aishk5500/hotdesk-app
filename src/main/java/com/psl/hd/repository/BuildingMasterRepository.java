package com.psl.hd.repository;

import com.psl.hd.model.BuildingMaster;
import com.psl.hd.model.CityMaster;
import com.psl.hd.model.OfficeMaster;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingMasterRepository extends JpaRepository<BuildingMaster, Integer> {
    List<BuildingMaster> findByOfficeid(OfficeMaster officeid);


}
