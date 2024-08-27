package com.api.mysql.api_try3.models;

import jakarta.persistence.*;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    private Long idRoom;
    private String name;
    private String password;

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
