package com.api.mysql.api_try3.service;

import com.api.mysql.api_try3.models.Task;

import java.util.List;

public interface TaskService {
    public Task createTask(Task task);
    public String deleteTask(Long idTask);
    public Task updateTask(Task task);
    public Task getTask(Long idRoom, String date, String time, String name, String points, String checkBoxes);
    public List<Task> getTasks(Long idRoom);

}
