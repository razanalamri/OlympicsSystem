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
    @RequestMapping(value = "getByAthleteName", method = RequestMethod.GET)
    public Athlete getByAthleteName(@RequestParam String name){
        Athlete athlete=athleteService.getByAthleteName(name);
        return athlete;
    }

    @RequestMapping(value = "getByAthleteNationality", method = RequestMethod.GET)
    public Athlete getByAthleteNationality(@RequestParam String nationality){
        Athlete athlete=athleteService.getByAthleteNationality(nationality);
        return athlete;
    }

    @RequestMapping(value = "getByAthleteSport", method = RequestMethod.GET)
    public Athlete getByAthleteSport(@RequestParam String sport){
        Athlete athlete=athleteService.getByAthleteSport(sport);
        return athlete;
    }
}
