package com.api.mysql.api_try3.service;

import com.api.mysql.api_try3.models.Task;

import java.sql.Date;
import java.util.List;

public interface TaskService {
    public String createTask(Task task);
    public String deleteTask(Task task);
    public Task getTaskByDate(Long idRoom, Date date, String time, String name, String points, String checkBoxes);
    public List<Task> getTasks(Long idRoom);

}
