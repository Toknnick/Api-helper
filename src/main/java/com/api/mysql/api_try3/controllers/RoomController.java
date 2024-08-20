package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.Room;
import com.api.mysql.api_try3.service.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/get/{idRoom}")
    public Room getRoomDetails(@PathVariable("idRoom") Long idRoom) {
        return roomService.getRoom(idRoom);
    }


    @PostMapping("/create")
    public String createRoom(@RequestBody Room room) {
        roomService.createRoom(room);
        return "Room created successfully";
    }

    @PutMapping("/update")
    public String updateRoom(@RequestBody Room room) {
        if(roomService.getRoom(room.getIdRoom()) != null) {
            roomService.updateRoom(room);
            return "Room updated successfully";
        }else{
            return "Room does not exist";
        }
    }

}
