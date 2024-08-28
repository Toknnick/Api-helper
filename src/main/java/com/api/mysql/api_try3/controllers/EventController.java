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


    @GetMapping("/get/one")
    public Event getEventDetails(@RequestBody Event event) {
        return eventService.getEvent(event.getIdRoom(), event.getDate(), event.getTime(), event.getPlace(), event.getEvent());
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
