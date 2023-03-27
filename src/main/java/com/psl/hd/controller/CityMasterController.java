package com.psl.hd.controller;
import com.psl.hd.model.CityMaster;
import com.psl.hd.repository.CityMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityMasterController extends Exception{
    @Autowired
    private CityMasterRepository cityMasterRepository;
    @GetMapping("/getAll")
    public List<CityMaster> getAllCities(){
        return cityMasterRepository.findAll();
    }
    //get city by Id
    @GetMapping("{id}")
    public ResponseEntity<CityMaster> getCityById(@PathVariable  int id) {
        return ResponseEntity.ok(cityMasterRepository.findById(id).get());}
    @PostMapping("/create")
    public CityMaster createCity(@RequestBody CityMaster cityMaster){
        return cityMasterRepository.save(cityMaster);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<CityMaster> updateCity(@PathVariable int id, @RequestBody CityMaster cityMaster) {
        CityMaster updateCity = cityMasterRepository.findById(id).get();
        updateCity.setIsactive(cityMaster.isIsactive());
        updateCity.setCityname(cityMaster.getCityname());
        updateCity.setStatename(cityMaster.getStatename());
        updateCity.setCountry(cityMaster.getCountry());
        updateCity.setPincode(cityMaster.getPincode());
         cityMasterRepository.save(cityMaster);
         return ResponseEntity.ok(updateCity);
    }
    // delete City REST API
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable int id){
        CityMaster cityMaster = cityMasterRepository.findById(id).get();
        cityMasterRepository.delete(cityMaster);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
