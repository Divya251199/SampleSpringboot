package com.example.UniversityManagementSystem.services;

import com.example.UniversityManagementSystem.model.Event;
import com.example.UniversityManagementSystem.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventServices {

    @Autowired
    IEventRepo eventRepo;

    public String addEvents(List<Event> eventList) {
        Iterable<Event> list = eventRepo.saveAll(eventList);

        if(list==null){
            return "Events not added successfully";
        }

        return "Events added successfully";
    }

    public String deleteEvent(Integer id) {
        Optional<Event> list = eventRepo.findById(id);

        if(!(list.isEmpty())){
            eventRepo.deleteById(id);
            return "Event with eventId" + id + " deleted successfully";
        }

        return "Event with eventId " + id + " not found";
    }

    public String updateEvent(Integer id, Event event) {
        Optional<Event> list = eventRepo.findById(id);
        event.setEventId(id);

        if(!(list.isEmpty())){
            eventRepo.save(event);
            return "Event with eventId" + id + " updated successfully";
        }

        return "Event with eventId " + id + " not found";
    }

    public List<Event> getEventsBasedOnDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return eventRepo.findByDate(localDate);
    }
}
