package com.api.mysql.api_try3.repository;

import com.api.mysql.api_try3.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.idRoom = :idRoom AND e.date = :date AND e.time = :time AND e.place = :place AND e.event = :event")
    Event findEventByCriteria(@Param("idRoom") Long idRoom, @Param("date") String date, @Param("time") String time, @Param("place") String place, @Param("event") String event);

    List<Event> findByIdRoom(Long idRoom);
}
