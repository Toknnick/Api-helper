package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.Room;
import com.api.mysql.api_try3.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/get/{idRoom}")
    public Room getRoomDetails(@PathVariable("idRoom") int idRoom) {
        return roomService.getRoom(idRoom);
    }

    @GetMapping("/get/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }


    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room) {
        roomService.createRoom(room);
        return room;
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room) {
        if(roomService.getRoom(room.getIdRoom()) != null) {
            roomService.updateRoom(room);
            return room;
        }else{
            return null;
        }
    }

    @DeleteMapping("/delete/{idRoom}")
    public String deleteRoom(@PathVariable("idRoom") int idRoom) {
        roomService.deleteRoom(idRoom);
        return "Room deleted successfully";
    }

}
