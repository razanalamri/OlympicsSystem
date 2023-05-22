package com.example.demo.Services;
import com.example.demo.DTO.EventReportObject;
import com.example.demo.Models.Event;
import com.example.demo.Repositry.EventRepositry;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class EventService {

    public static final String pathToReports = "C:\\Users\\user012\\Downloads\\Reports";

    @Autowired
    EventRepositry eventRepositry;

    public List<Event> getAllEvents() {
        return eventRepositry.getAllEvents();
    }


    public Event getById(Integer id) {
        Event event = eventRepositry.getById(id);
        return event;
    }

    public String generateReportOfEvents(int year,int month) throws FileNotFoundException, JRException {
        List<Event> events = eventRepositry.getAllEvents();
        List<EventReportObject> eventReportObjects = new ArrayList<>();

        for (Event event : events) {
            LocalDate eventDate = event.getSchedule().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (eventDate.getYear() == year && eventDate.getMonthValue() == month) {
                String name = event.getName();
                Integer numberOfAthletes = event.getNumberOfAthletes();
                Date createdDate = event.getCreatedDate();
                Date updatedDate = event.getUpdatedDate();
                Boolean isActive = event.getIsActive();
                EventReportObject eventReportObject = new EventReportObject(name, numberOfAthletes, createdDate, updatedDate, isActive);
                eventReportObjects.add(eventReportObject);
            }}

            File file = ResourceUtils.getFile("classpath:EventsReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            var dataSource = new JRBeanCollectionDataSource(eventReportObjects);
            Map<String, Object> paramters = new HashMap<>();
            paramters.put("CreatedBy", "Razan");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Transaction.pdf");
            return "Report generated : " + pathToReports + "\\Transaction.pdf";
        }



         }
