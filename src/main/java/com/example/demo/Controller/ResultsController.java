package com.example.demo.Controller;

import com.example.demo.Models.Medal;
import com.example.demo.Models.Results;
import com.example.demo.Services.MedalService;
import com.example.demo.Services.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "results" )
public class ResultsController {

   @Autowired
    ResultsService resultsService;
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Results> getAllResults(){
        List<Results> results = resultsService.getAllResults();
        return results;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Results getById(@RequestParam Integer id){
        Results results=resultsService.getById(id);
        return results;
    }





}