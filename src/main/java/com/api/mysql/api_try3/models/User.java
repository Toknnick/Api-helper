package com.api.mysql.api_try3.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    private String login;

    private String password;
    private int ownRoom;
    private String availableRooms;

    public User() {
    }

    public User(String login, String password, String availableRooms, int ownRoom) {
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


    public int getOwnRoom() {
        return ownRoom;
    }

    public void setOwnRoom(int ownRoom) {
        this.ownRoom = ownRoom;
    }


}
