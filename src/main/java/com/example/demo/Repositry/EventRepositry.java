package com.example.demo.Repositry;
import com.example.demo.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepositry extends JpaRepository<Event,Integer> {

    @Query("SELECT s from Event s")
    List<Event> getAllEvents();
    @Query(value="SELECT s from Event s where s.id = :id ")
    Event getById(@Param("id")Integer id);






}
