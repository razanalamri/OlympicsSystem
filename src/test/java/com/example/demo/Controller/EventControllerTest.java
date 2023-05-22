package com.example.demo.Controller;

import com.example.demo.Models.Athlete;
import com.example.demo.Models.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventControllerTest {
    @Autowired
    EventController eventController;
    @Test
    void getAllEvents() {
        List<Event> allEvents = eventController.getAllEvents();
        assertNotNull(allEvents);
    }

    @Test
    void getById() {
        Event eventToTest;
        eventToTest=eventController.getById(3);
        String name=eventToTest.getName();
        assertEquals("Summer Olympic Sports",name);
    }


}


