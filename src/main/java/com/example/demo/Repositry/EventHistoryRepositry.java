package com.example.demo.Repositry;
import com.example.demo.Models.EventsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventHistoryRepositry extends JpaRepository<EventsHistory,Integer> {

    @Query("SELECT s from EventsHistory s")
    List<EventsHistory> getAllEventsHistory();
    @Query(value="SELECT s from EventsHistory s where s.id = :id ")
    EventsHistory getById(@Param("id")Integer id);
}
