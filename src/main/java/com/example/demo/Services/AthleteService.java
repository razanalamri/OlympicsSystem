package com.example.demo.Services;

import com.example.demo.Models.Athlete;
import com.example.demo.Repositry.AthleteRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AthleteService {
@Autowired
AthleteRepositry athleteRepositry;
    public List<Athlete> getAllAthletes() {
        return athleteRepositry.getAllAthletes();
    }

    public Athlete getById(Integer id) {
        Athlete athlete = athleteRepositry.getById(id);
        return athlete;
    }




    

}
