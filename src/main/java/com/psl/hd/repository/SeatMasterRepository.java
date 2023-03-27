package com.psl.hd.repository;

import com.psl.hd.model.FloorMaster;
import com.psl.hd.model.SeatMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatMasterRepository extends JpaRepository<SeatMaster,Integer> {
    List<SeatMaster> findByFloorid(FloorMaster floorid);

}
