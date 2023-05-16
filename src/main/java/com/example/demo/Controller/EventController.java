package com.example.demo.Controller;

import com.example.demo.Models.Athlete;
import com.example.demo.Models.Event;
import com.example.demo.Services.EventService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value= "event" )
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<Event> getAllEvents(){
        List<Event> events = eventService.getAllEvents();
        return events;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Event getById(@RequestParam Integer id){
        Event event=eventService.getById(id);
        return event;
    }

    @RequestMapping(value="generateReportOfEvents",method = RequestMethod.GET)
    public String generateReportOfEvents( int year,int month) throws JRException, FileNotFoundException {
        return eventService.generateReportOfEvents(year,month);
    }






}
