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
    public String deleteRoom(@PathVariable("idRoom") Long idRoom) {
        roomService.deleteRoom(idRoom);
        return "Room deleted successfully";
    }

}
