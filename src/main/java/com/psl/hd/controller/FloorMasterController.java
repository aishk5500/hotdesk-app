package com.psl.hd.controller;

import com.psl.hd.model.BuildingMaster;
import com.psl.hd.model.FloorMaster;
import com.psl.hd.repository.FloorMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floor")
public class FloorMasterController {
    @Autowired
    FloorMasterRepository floorMasterRepository;
    @GetMapping("/getAll")
    public List<FloorMaster> getAllFloor(){
        return floorMasterRepository.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<FloorMaster> getById(@PathVariable  int id) throws Exception {
        return ResponseEntity.ok(floorMasterRepository.findById(id).get());}
    @PostMapping("/create")
    public FloorMaster createBuilding(@RequestBody FloorMaster floorMaster){
        return floorMasterRepository.save(floorMaster);}
    // update Floor by Id
    @PutMapping("update/{id}")
    public ResponseEntity<FloorMaster> updateFloor(@PathVariable int id, @RequestBody FloorMaster floorMaster) {
        FloorMaster updateFloor = floorMasterRepository.findById(id).get();
        updateFloor.setFloorid(updateFloor.getFloorid());
        updateFloor.setIsactive(floorMaster.isIsactive());
        updateFloor.setFloorname(floorMaster.getFloorname());
        updateFloor.setFloorplan(floorMaster.getFloorplan());
        updateFloor.setBuildingid(floorMaster.getBuildingid());
        floorMasterRepository.save(floorMaster);
        return ResponseEntity.ok(updateFloor);
    }
    //delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable int id){
        FloorMaster floorMaster = floorMasterRepository.findById(id).get();
        floorMasterRepository.delete(floorMaster);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping("/getByBuildingId/{id}")
    public @ResponseBody List<FloorMaster> findByBuilding(@PathVariable BuildingMaster id) {
        return floorMasterRepository.findByBuildingid(id);
    }
}
