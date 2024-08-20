package com.api.mysql.api_try3.service;

import com.api.mysql.api_try3.models.Event;

import java.sql.Date;
import java.util.List;

public interface EventService {
    public String createEvent(Event event);
    public String deleteEvent(Event event);
    public Event getEventByDate(Long idRoom, Date date, String time, String place, String event);
    public List<Event> getEvents(Long idRoom);
}
