package com.example.demo.Services;

import com.example.demo.Models.Event;
import com.example.demo.Models.EventsHistory;
import com.example.demo.Repositry.EventHistoryRepositry;
import com.example.demo.Repositry.EventRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventHistoryService {

    @Autowired
    EventHistoryRepositry eventHistoryRepositry;

    public List<EventsHistory> getAllEventsHistory() {
        return eventHistoryRepositry.getAllEventsHistory();
    }
    public EventsHistory getById(Integer id) {
        EventsHistory eventsHistory = eventHistoryRepositry.getById(id);
        return eventsHistory;
    }
}
