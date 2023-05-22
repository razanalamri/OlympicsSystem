package com.example.demo.Controller;

import com.example.demo.Models.Athlete;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AthleteControllerTest {

    @Autowired
    AthleteController athleteController;
    @Test
    void getAllAthletes() throws Exception{
        List<Athlete> allAthletes = athleteController.getAllAthletes();
        assertNotNull(allAthletes);
    }
    @Test
    void getById1()throws Exception {
        Athlete athleteToTest;
        athleteToTest=athleteController.getById(1);
        String name=athleteToTest.getName();
        assertEquals("Firas",name);
    }

    @Test
    void getByAthleteName() {
        Athlete athleteToTest;
        athleteToTest=athleteController.getByAthleteName("Asaad");
        Integer id=athleteToTest.getId();
        assertEquals(1,id);
    }

    @Test
    void getByAthleteNationality() {
        Athlete athleteToTest;
        athleteToTest=athleteController.getByAthleteNationality("Oman");
        Integer id=athleteToTest.getId();
        assertEquals(1,id);
    }

    @Test
    void getByAthleteSport() {
        Athlete athleteToTest;
        athleteToTest=athleteController.getByAthleteSport("Boxing");
        Integer id=athleteToTest.getId();
        assertEquals(1,id);
    }




}