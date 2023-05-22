package com.example.demo.Controller;

import com.example.demo.Models.Event;
import com.example.demo.Models.EventsHistory;
import com.example.demo.Services.EventHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "eventHistory")
public class EventHistoryController {

    @Autowired
    EventHistoryService eventHistoryService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<EventsHistory> getAllEventsHistory() {
        List<EventsHistory> eventsHistory = eventHistoryService.getAllEventsHistory();
        return eventsHistory;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public EventsHistory getById(@RequestParam Integer id) {
        EventsHistory eventsHistory = eventHistoryService.getById(id);
        return eventsHistory;
    }
}
