package com.psl.hd.repository;

import com.psl.hd.model.BuildingMaster;
import com.psl.hd.model.CityMaster;
import com.psl.hd.model.OfficeMaster;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface OfficeMasterRepository extends JpaRepository<OfficeMaster, Integer> {
    List<OfficeMaster> findByCityid(CityMaster cityid);

}
