package com.example.demo.Controller;

import com.example.demo.Models.EventsHistory;
import com.example.demo.Models.Medal;
import com.example.demo.Models.Results;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ResultsControllerTest {
@Autowired
ResultsController resultsController;
    @Test
    void getAllResults() {
        List<Results> allResults = resultsController.getAllResults();
        assertNotNull(allResults);

    }

    @Test
    void getById() {
        Results resultToTest;
        resultToTest=resultsController.getById(1);
        String athlete=resultToTest.getAthlete();
        assertEquals("Asaad",athlete);

    }



}