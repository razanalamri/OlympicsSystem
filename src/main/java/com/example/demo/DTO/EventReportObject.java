package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class EventReportObject {
    String name;
    Integer numberOfAthletes;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;

    public EventReportObject(String name, Integer numberOfAthletes, Date createdDate, Date updatedDate, Boolean isActive) {
        this.name = name;
        this.numberOfAthletes = numberOfAthletes;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActive = isActive;
    }


}
