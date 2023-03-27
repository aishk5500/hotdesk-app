package com.psl.hd.controller;

import com.psl.hd.model.SeatType;
import com.psl.hd.repository.SeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seattype")
public class SeatTypeController {
    @Autowired
    SeatTypeRepository seatTypeRepository;
    @GetMapping("/getAll")
    public List<SeatType> getAllSeat(){
        return seatTypeRepository.findAll();
    }
    @PostMapping("/create")
    public SeatType createSeat(@RequestBody SeatType seatType){
        return seatTypeRepository.save(seatType);
    }
    // get building by Id
    @GetMapping("getBySeatID/{id}")
    public ResponseEntity<SeatType> getSeattypebyid(@PathVariable  int id){
        SeatType seatType = seatTypeRepository.findById(id).get();
        return  ResponseEntity.ok(seatType);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<SeatType> updateSeattype(@PathVariable int id,@RequestBody SeatType seatType) {
        SeatType updateSeattype = seatTypeRepository.findById(id).get();
        updateSeattype.setSeatcode(seatType.getSeatcode());
        updateSeattype.setSeatname(seatType.getSeatname());
        seatTypeRepository.save(seatType);
        return ResponseEntity.ok(updateSeattype);
    }
    //delete by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteSeattype(@PathVariable int id){
        SeatType seatType = seatTypeRepository.findById(id).get();
        seatTypeRepository.delete(seatType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
