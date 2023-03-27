package com.psl.hd.controller;

import com.psl.hd.model.BuildingMaster;
import com.psl.hd.model.OfficeMaster;
import com.psl.hd.repository.BuildingMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingMasterController {
    @Autowired
    BuildingMasterRepository buildingMasterRepository;
    @GetMapping("getAll")
    public ResponseEntity<List<BuildingMaster>> getAllBuildings(){
        return ResponseEntity.ok(buildingMasterRepository.findAll());
        //orElseThrow(()->new NotFoundException(" not found")));
    }
    @GetMapping("{id}")
    public ResponseEntity<BuildingMaster> getById(@PathVariable  int id) {
        return ResponseEntity.ok(buildingMasterRepository.findById(id).get());
    }
    @PostMapping("create")
    public BuildingMaster createBuilding(@RequestBody BuildingMaster buildingMaster){
        return buildingMasterRepository.save(buildingMaster);
    }
    //find by building id
    @RequestMapping("/getByOfficeId/{id}")
    public @ResponseBody List<BuildingMaster> findByOffice(@PathVariable OfficeMaster id) {
        return buildingMasterRepository.findByOfficeid(id);
    }
    // update building by Id
    @PutMapping("update/{id}")
    public ResponseEntity<BuildingMaster> updateBuilding(@PathVariable int id, @RequestBody BuildingMaster buildingMaster) {
        BuildingMaster updateBuilding = buildingMasterRepository.findById(id).get();
        updateBuilding.setIsactive(buildingMaster.isIsactive());
        updateBuilding.setBuildingname(buildingMaster.getBuildingname());
        updateBuilding.setOfficeid(buildingMaster.getOfficeid());
        buildingMasterRepository.save(buildingMaster);
        return ResponseEntity.ok(updateBuilding);
    }
    //delete by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteOffice(@PathVariable int id){
        BuildingMaster buildingMaster = buildingMasterRepository.findById(id).get();
        buildingMasterRepository.delete(buildingMaster);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
