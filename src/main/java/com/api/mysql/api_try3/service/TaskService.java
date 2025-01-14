package com.api.mysql.api_try3.service;

import com.api.mysql.api_try3.models.Task;

import java.util.List;

public interface TaskService {
    public Task createTask(Task task);
    public String deleteTask(int idTask);
    public Task updateTask(Task task);
    public Task getTask(int idRoom, String date, String time, String name, String points, String checkBoxes);
    public List<Task> getTasksByIdRoom(int idRoom);
    public List<Task> getAllTasks();


}
