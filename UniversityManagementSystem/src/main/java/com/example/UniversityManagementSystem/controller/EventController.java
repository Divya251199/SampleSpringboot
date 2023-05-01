package com.example.UniversityManagementSystem.controller;

import com.example.UniversityManagementSystem.model.Event;
import com.example.UniversityManagementSystem.services.EventServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventServices eventServices;

    @PostMapping(value = "events")
    public String addEvents(@Valid @RequestBody List<Event> eventList){
        return eventServices.addEvents(eventList);
    }

    @GetMapping(value = "events")
    public List<Event> getEventsBasedOnDate(@RequestParam String date){
        return eventServices.getEventsBasedOnDate(date);
    }

    @DeleteMapping(value = "events/{id}")
    public String deleteEvent(@PathVariable Integer id){
        return eventServices.deleteEvent(id);
    }

    @PutMapping(value = "events/{id}")
    public String updateEvent(@PathVariable Integer id , @RequestBody Event event){
        return eventServices.updateEvent(id , event);
    }



}
