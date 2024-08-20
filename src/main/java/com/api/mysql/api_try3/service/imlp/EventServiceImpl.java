package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Event;
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
    public String createEvent(Event event) {
        eventRepository.save(event);
        return "Success";
    }

    @Override
    public String deleteEvent(Event event) {
        eventRepository.deleteById(event.getIdEvent());
        return "Success";
    }

    @Override
    public Event getEventByDate(Long idRoom, Date date, String time, String place, String event) {
        return eventRepository.findEventByCriteria(idRoom, date, time, place, event).get(0);
    }

    @Override
    public List<Event> getEvents(Long idRoom) {
        return eventRepository.findByIdRoom(idRoom);
    }
}
