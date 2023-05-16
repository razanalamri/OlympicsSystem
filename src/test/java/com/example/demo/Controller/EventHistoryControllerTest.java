package com.example.demo.Controller;

import com.example.demo.Models.Event;
import com.example.demo.Models.EventsHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventHistoryControllerTest {
    @Autowired
    EventHistoryController eventHistoryController;

    @Test
    void getAllEventsHistory() {
        List<EventsHistory> allEventsHistory = eventHistoryController.getAllEventsHistory();
        assertNotNull(allEventsHistory);
    }

    @Test
    void getById() {
        EventsHistory eventHistoryToTest;
        eventHistoryToTest=eventHistoryController.getById(1);
        String name=eventHistoryToTest.getName();
        assertEquals("men's Artistic Team All-Around",name);
    }





}