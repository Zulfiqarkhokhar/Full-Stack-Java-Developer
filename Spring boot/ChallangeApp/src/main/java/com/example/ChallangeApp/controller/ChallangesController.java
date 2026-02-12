package com.example.ChallangeApp.controller;

import com.example.ChallangeApp.entity.Challanges;
import com.example.ChallangeApp.service.ChallangesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challanges")
public class ChallangesController {

    private ChallangesService challangesService;

    public ChallangesController(ChallangesService challangesService){
        this.challangesService = challangesService;
    }

    @GetMapping
    public ResponseEntity<List<Challanges>> getAllChallanges(){
        return new ResponseEntity<>(challangesService.getAllChallanges(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallange(@RequestBody Challanges challange){
        boolean isChallangeAdded = challangesService.addChallange(challange);
        if(isChallangeAdded){
            return new ResponseEntity<>("Challange Added Successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Challange Not Added",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challanges> getChallangeByMonth(@PathVariable String month){
        Challanges challanges = challangesService.getChallangeByMonth(month);
        if(challanges != null){
            return new ResponseEntity<>(challanges, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallange(@PathVariable Long id,@RequestBody Challanges updateChallange){
        boolean isUpdated = challangesService.updateChallange(id,updateChallange);
        if(isUpdated){
            return new ResponseEntity<>("Challange Updated Successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Challange Not Updated",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallange(@PathVariable Long id){
        boolean isChallangeDeleted = challangesService.deleteChallange(id);
        if(isChallangeDeleted){
            return new ResponseEntity<>("Challange Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Challange Not Deleted",HttpStatus.BAD_REQUEST);
    }
}
