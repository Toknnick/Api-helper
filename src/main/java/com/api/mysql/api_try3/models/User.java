package com.api.mysql.api_try3.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(unique = true)
    private String login;

    private String password;
    private Long ownRoom;
    private String availableRooms;

    public User() {
    }

    public User(String login, String password, String availableRooms, Long ownRoom) {
        this.login = login;
        this.password = password;
        this.ownRoom = ownRoom;
        this.availableRooms = availableRooms;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(String availableRooms) {
        this.availableRooms = availableRooms;
    }


    public Long getOwnRoom() {
        return ownRoom;
    }

    public void setOwnRoom(Long ownRoom) {
        this.ownRoom = ownRoom;
    }


}
