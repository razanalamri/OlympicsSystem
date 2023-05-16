package com.example.demo.Controller;

import com.example.demo.Models.Athlete;
import com.example.demo.Models.Medal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MedalControllerTest {
   @Autowired
   MedalController medalController;
    @Test
    void getById() {
        Medal medalToTest;
        medalToTest=medalController.getById(1);
        String country=medalToTest.getCountry();
        assertEquals("Oman",country);
    }




}