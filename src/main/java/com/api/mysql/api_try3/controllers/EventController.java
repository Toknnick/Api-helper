package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.Event;
import com.api.mysql.api_try3.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/get/one/{idRoom}/{date}/{time}/{place}/{event}")
    public Event getEventDetails(@PathVariable("idRoom") Long idRoom,@PathVariable("date") String date,@PathVariable("time")String time
            ,@PathVariable("place") String place,@PathVariable("event") String event) {
        return eventService.getEvent(idRoom, date, time, place, event);
    }

    @GetMapping("/get/all/{idRoom}")
    public List<Event> getEventDetails(@PathVariable("idRoom") Long idRoom) {
        return eventService.getEvents(idRoom);
    }

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return event;
    }

    @PutMapping("/update")
    public Event updateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
        return event;
    }

    @DeleteMapping("/delete/{idEvent}")
    public String deleteEvent(@PathVariable("idEvent") Long idEvent) {
        eventService.deleteEvent(idEvent);
        return "Event deleted successfully";
    }

}
