package com.example.demo.Repositry;

import com.example.demo.Models.Event;
import com.example.demo.Models.Medal;
import com.example.demo.Models.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultsRepositry extends JpaRepository<Results,Integer> {

    @Query("SELECT s from Results s")
    List<Results> getAllResults();
    @Query(value="SELECT s from Results s where s.id = :id ")
    Results getById(@Param("id")Integer id);

    @Query(value="SELECT s from Results s where s.updatedDate=(select MAX(s.updatedDate) from Results s)")
    List<Results> getLatestUpdate();
}

