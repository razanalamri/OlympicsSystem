package com.example.demo.Services;

import com.example.demo.DTO.EventReportObject;
import com.example.demo.DTO.TopWonObject;
import com.example.demo.Models.Event;
import com.example.demo.Models.Medal;
import com.example.demo.Models.Results;
import com.example.demo.Repositry.MedalRepositry;
import com.example.demo.Repositry.ResultsRepositry;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class MedalService {
    public static final String pathToReports = "C:\\Users\\user012\\Downloads\\Reports";
    @Autowired
    MedalRepositry medalRepositry;

    @Autowired
    ResultsRepositry resultsRepositry;

    public List<Medal> getAllMedals() {
        return medalRepositry.getAllMedals();
    }

    public Medal getById(Integer id) {
        Medal medal = medalRepositry.getById(id);
        return medal;
    }

    public Medal getByCountryName(String country) {
        Medal medal = medalRepositry.getByCountryName(country);
        return medal;
    }

    public String generateReportOfWonCountries(String country) throws FileNotFoundException, JRException {
        Medal medal = medalRepositry.getByCountryName(country);
        List<TopWonObject> topWonObjects = new ArrayList<>();
        String countryName = medal.getCountry();
        Integer gold = medal.getGold();
        TopWonObject topWonObject = new TopWonObject(countryName, gold);
        topWonObjects.add(topWonObject);


        File file = ResourceUtils.getFile("classpath:TopWonReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        var dataSource = new JRBeanCollectionDataSource(topWonObjects);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Razan");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopWon.pdf");
        return "Report generated : " + pathToReports + "\\TopWon.pdf";
    }

    public List<Medal> getMedalsByResultsId(Integer id) {
        List<Medal> medals = medalRepositry.getMedalsByResultsId(id);
        return medals;
    }

    public void updateMedals(Integer gold){
       List <Medal> medal=medalRepositry.getAllMedals();
        Results results=resultsRepositry.getLatestUpdate();
        for (Medal medal1 : medal) {
            String countryName = medal1.getCountry();
            String resultCountry = results.getCountry();
            if(countryName==resultCountry){
                medal1.setGold(gold+1);
                medalRepositry.save(medal1);
        }}


}}
