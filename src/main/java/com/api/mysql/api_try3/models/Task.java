package com.api.mysql.api_try3.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    private Long idTask;
    private Long idRoom;
    private Date date;
    private String time;
    private String name;
    private String points;
    private String checkBoxes;

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getCheckBoxes() {
        return checkBoxes;
    }

    public void setCheckBoxes(String checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public Long getIdTask() {
        return idTask;
    }
}
