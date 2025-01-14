package com.api.mysql.api_try3.service;

import com.api.mysql.api_try3.models.Event;

import java.util.List;

public interface EventService {
    public Event createEvent(Event event);
    public String deleteEvent(int idEvent);
    public Event updateEvent(Event event);
    public Event getEvent(int idRoom, String date, String time, String place,String event);
    public List<Event> getEventsByIdRoom(int idRoom);
    public List<Event> getAllEvents();
}
