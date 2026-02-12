package com.example.ChallangeApp.service;

import com.example.ChallangeApp.entity.Challanges;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallangesService {

    private List<Challanges> challanges = new ArrayList<>();

    public ChallangesService(){
        challanges.add(new Challanges(1L,"First Challange","January"));
        challanges.add(new Challanges(2L,"Second Challange","February"));
    }

    public List<Challanges> getAllChallanges(){
        return challanges;
    }

    public boolean addChallange(Challanges challange){
        if(challange != null){
            challanges.add(challange);
            return true;
        }
        return false;
    }

    public Challanges getChallangeByMonth(String month) {
        for(Challanges challange:challanges){
            if(challange.getMonth().equalsIgnoreCase(month)){
                return challange;
            }
        }
        return null;
    }

    public boolean updateChallange(Long id, Challanges updateChallange) {
        for (Challanges challange : challanges) {
            if (challange.getId().equals(id)) {
                challange.setDescription(updateChallange.getDescription());
                challange.setMonth(updateChallange.getMonth());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallange(Long id) {
        return challanges.removeIf(challange->challange.getId().equals(id));
    }
}
