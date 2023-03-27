package com.psl.hd.controller;

import com.psl.hd.model.FloorMaster;
import com.psl.hd.model.SeatMaster;
import com.psl.hd.repository.SeatMasterRepository;
import com.psl.hd.repository.SeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seatmaster")
public class SeatMasterController {
    @Autowired
    SeatMasterRepository seatMasterRepository;
    @Autowired
    private SeatTypeRepository seatTypeRepository;
    @GetMapping("/getAll")
    public List<SeatMaster> getAllSeatMaster(){return seatMasterRepository.findAll();}
    @GetMapping("{id}")
    public ResponseEntity<SeatMaster> getById(@PathVariable  int id) throws Exception {
        return ResponseEntity.ok(seatMasterRepository.findById(id).get());
    }
    @PostMapping("/create")
    public SeatMaster saveSeatMaster(@RequestBody SeatMaster seatMaster){
        return seatMasterRepository.save(seatMaster);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<SeatMaster> updateSeattype(@PathVariable int id,@RequestBody SeatMaster seatMaster) {
        SeatMaster updateSeatMaster = seatMasterRepository.findById(id).get();
        updateSeatMaster.setIsactive(seatMaster.isIsactive());
        updateSeatMaster.setCubibleposition(seatMaster.getCubibleposition());
        updateSeatMaster.setQrnumber(updateSeatMaster.getQrnumber());
        updateSeatMaster.setSeatnumber(seatMaster.getSeatnumber());
        updateSeatMaster.setSeatid(seatMaster.getSeatid());
        updateSeatMaster.setFloorid(seatMaster.getFloorid());
        updateSeatMaster.setSeattypeid(seatMaster.getSeattypeid());
        seatMasterRepository.save(seatMaster);
        return ResponseEntity.ok(updateSeatMaster);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteSeatMaster(@PathVariable int id){
        SeatMaster seatMaster = seatMasterRepository.findById(id).get();
        seatMasterRepository.delete(seatMaster);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping("/getByFloorId/{id}")
    public @ResponseBody List<SeatMaster> findByBuilding(@PathVariable FloorMaster id) {
        return seatMasterRepository.findByFloorid(id);
    }
}
