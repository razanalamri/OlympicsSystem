package com.example.demo.Repositry;

import com.example.demo.Models.Event;
import com.example.demo.Models.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedalRepositry extends JpaRepository<Medal, Integer> {


    @Query("SELECT s from Medal s")
    List<Medal> getAllMedals();

    @Query(value = "SELECT s from Medal s where s.id = :id ")
    Medal getById(@Param("id") Integer id);

    @Query(value = "SELECT s from Medal s where s.country = :country")
    Medal getByCountryName(@Param("country") String country);

    @Query(value = "SELECT s from Medal s WHERE s.results.id = :id ")
    List<Medal> getMedalsByResultsId(@Param("id") Integer id);

}
