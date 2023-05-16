package com.example.demo.Controller;

import com.example.demo.Models.EventsHistory;
import com.example.demo.Models.Medal;
import com.example.demo.Services.MedalService;
import com.example.demo.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value= "medal" )
public class MedalController {
    @Autowired
    SlackClient slackClient;

    @Autowired
    MedalService medalService;


    @Scheduled(cron = "0 0/5 * * * *")
    public List<Medal> getAllMedals(){
        List<Medal> medals = medalService.getAllMedals();
        for(Medal medalData : medals) {
            slackClient.sendMessage(medalData.getId().toString());
            slackClient.sendMessage(medalData.getCountry());
            slackClient.sendMessage(medalData.getBronze().toString());
            slackClient.sendMessage(medalData.getGold().toString());
            slackClient.sendMessage(medalData.getSilver().toString());
            slackClient.sendMessage(medalData.getCreatedDate().toString());
            slackClient.sendMessage(medalData.getUpdatedDate().toString());
            slackClient.sendMessage(medalData.getActive().toString());
        }
        return medals;
    }


    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Medal getById(@RequestParam Integer id){
        Medal medal=medalService.getById(id);
        return medal;
    }

    @RequestMapping(value = "getByCountryName", method = RequestMethod.GET)
    public Medal getByCountryName(@RequestParam String country){
        Medal medal=medalService.getByCountryName(country);
        return medal;
    }


    @RequestMapping(value="generateReportOfWonCountries",method = RequestMethod.GET)
    public String generateReportOfWonCountries(String country) throws JRException, FileNotFoundException {
        return medalService.generateReportOfWonCountries(country);
    }
}
