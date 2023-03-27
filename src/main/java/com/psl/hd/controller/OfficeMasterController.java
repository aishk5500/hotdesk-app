package com.psl.hd.controller;
import com.psl.hd.model.CityMaster;
import com.psl.hd.model.OfficeMaster;
import com.psl.hd.repository.OfficeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeMasterController {
    @Autowired
    private OfficeMasterRepository officeMasterRepository;

    @GetMapping("/getAll")
    public List<OfficeMaster> getAllOffice(){
        return officeMasterRepository.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<OfficeMaster> getById(@PathVariable  int id) throws Exception {
        return ResponseEntity.ok(officeMasterRepository.findById(id).get());
    }
    @PostMapping("/create")
    public OfficeMaster createOffice(@RequestBody OfficeMaster officeMaster){
        return officeMasterRepository.save(officeMaster);
    }
    //obtaining office by city id
    @RequestMapping("/getByCityId/{id}")
    public @ResponseBody List<OfficeMaster> findByCity(@PathVariable CityMaster id) {
        return officeMasterRepository.findByCityid(id);
    }
    //updating with id
    @PutMapping("update/{id}")
    public ResponseEntity<OfficeMaster> updateOffice(@PathVariable int id,@RequestBody OfficeMaster officeMaster) {
        OfficeMaster updateOffice = officeMasterRepository.findById(id).get();
        updateOffice.setIsactive(officeMaster.isIsactive());
        updateOffice.setOfficename(officeMaster.getOfficename());
        updateOffice.setCityid(officeMaster.getCityid());
        officeMasterRepository.save(officeMaster);
        return ResponseEntity.ok(updateOffice);
    }
    // build delete employee REST API
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteOffice(@PathVariable int id){
        OfficeMaster officeMaster = officeMasterRepository.findById(id).get();
        officeMasterRepository.delete(officeMaster);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
