package com.example.demo.Services;

import com.example.demo.Models.Event;
import com.example.demo.Models.Medal;
import com.example.demo.Models.Results;
import com.example.demo.Repositry.MedalRepositry;
import com.example.demo.Repositry.ResultsRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
@Service
public class ResultsService {

    @Autowired
    ResultsRepositry resultsRepositry;

    public List<Results> getAllResults() {
        return resultsRepositry.getAllResults();
    }
    public Results getById(Integer id) {
        Results results = resultsRepositry.getById(id);
        return results;

}

    public List<Results> getLatestUpdate(){return resultsRepositry.getLatestUpdate();}

    public void updateResults(Integer id,String athlete,String country,Double time,Boolean isActive){
        Results results =resultsRepositry.getById(id);
        results.setAthlete(athlete);
        results.setCountry(country);
        results.setTime(time);
        results.setCreatedDate(new Date());
        results.setActive(isActive);
        resultsRepositry.save(results);
    }


}
