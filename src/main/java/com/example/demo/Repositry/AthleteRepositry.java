package com.example.demo.Repositry;

import com.example.demo.Models.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AthleteRepositry extends JpaRepository<Athlete,Integer> {

    @Query("SELECT s from Athlete s")
    List<Athlete> getAllAthletes();
    @Query(value="SELECT s from Athlete s where s.id = :id ")
    Athlete getById(@Param("id")Integer id);

    @Query(value="SELECT s from Athlete s where s.name = :name")
    Athlete getByAthleteName(@Param("name")String name);

}
