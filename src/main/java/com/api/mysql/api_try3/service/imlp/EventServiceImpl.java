package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Event;
import com.api.mysql.api_try3.models.Room;
import com.api.mysql.api_try3.repository.EventRepository;
import com.api.mysql.api_try3.service.EventService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public Event createEvent(Event event) {
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        eventRepository.save(event);
        return event;
    }


    @Override
    public String deleteEvent(Long idEvent) {
        eventRepository.deleteById(idEvent);
        return "Success";
    }

    @Override
    public Event getEvent(Long idRoom, String date,String time, String place, String event) {
        return eventRepository.findEventByCriteria(idRoom, date,time,place,event);
    }

    @Override
    public List<Event> getEvents(Long idRoom) {
        return eventRepository.findByIdRoom(idRoom);
    }
}
