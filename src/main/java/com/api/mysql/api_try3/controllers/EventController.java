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
        return eventService.getEventByDate(event.getIdRoom(), event.getDate(), event.getTime(), event.getPlace(), event.getEvent());
    }

    @GetMapping("/get/all/{idRoom}")
    public List<Event> getEventDetails(@PathVariable("idRoom") Long idRoom) {
        return eventService.getEvents(idRoom);
    }

    @PostMapping("/create")
    public String createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return "Event created successfully";
    }

    @DeleteMapping("/delete")
    public String deleteEvent(@RequestBody Event tempEvent) {
        Event event = eventService.getEventByDate(tempEvent.getIdRoom(), tempEvent.getDate(), tempEvent.getTime(), tempEvent.getPlace(), tempEvent.getEvent());
        if(event != null) {
            eventService.deleteEvent(event);
            return "Event deleted successfully";
        }else{
            return "Event does not exist";
        }
    }

}
