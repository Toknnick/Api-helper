package com.api.mysql.api_try3.service;


import com.api.mysql.api_try3.models.Room;

public interface RoomService {
    public Room createRoom(Room room);
    public Room updateRoom(Room room);
    public String deleteRoom(Long idRoom);
    public Room getRoom(Long idRoom);
}
