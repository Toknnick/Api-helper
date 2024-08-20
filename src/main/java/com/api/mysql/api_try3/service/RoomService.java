package com.api.mysql.api_try3.service;


import com.api.mysql.api_try3.models.Room;

public interface RoomService {
    public String createRoom(Room room);
    public String updateRoom(Room room);
    public Room getRoom(Long idRoom);
}
