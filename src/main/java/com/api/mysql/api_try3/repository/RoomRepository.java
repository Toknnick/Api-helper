package com.api.mysql.api_try3.repository;

import com.api.mysql.api_try3.models.Event;
import com.api.mysql.api_try3.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
