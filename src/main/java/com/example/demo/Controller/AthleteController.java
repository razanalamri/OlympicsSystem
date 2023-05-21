package com.example.demo.Controller;

import com.example.demo.Models.Athlete;
import com.example.demo.Services.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "athlete" )
public class AthleteController {





    /// testing github
    @Autowired
    AthleteService athleteService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Athlete> getAllAthletes(){
        List<Athlete> athletes = athleteService.getAllAthletes();
        return athletes;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Athlete getById(@RequestParam Integer id){
        Athlete athlete=athleteService.getById(id);
        return athlete;

    }
}
