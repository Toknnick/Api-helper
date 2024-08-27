package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Room;
import com.api.mysql.api_try3.repository.EventRepository;
import com.api.mysql.api_try3.repository.RoomRepository;
import com.api.mysql.api_try3.service.EventService;
import com.api.mysql.api_try3.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(Room room) {
        roomRepository.save(room);
        return room;
    }

    @Override
    public Room updateRoom(Room room) {
        Room existingRoom = roomRepository.findById(room.getIdRoom()).orElse(new Room());
        existingRoom.setName(room.getName() != null ? room.getName() : existingRoom.getName());
        existingRoom.setPassword(room.getPassword() != null ? room.getPassword() : existingRoom.getPassword());
        roomRepository.save(existingRoom);
        return room;
    }

    @Override
    public Room getRoom(Long idRoom) {
        return roomRepository.findById(idRoom).orElse(null);
    }

    @Override
    public String deleteRoom(Long idRoom) {
        roomRepository.deleteById(idRoom);
        return "Success";
    }

}
