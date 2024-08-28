package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Event;
import com.api.mysql.api_try3.models.Task;
import com.api.mysql.api_try3.repository.TaskRepository;
import com.api.mysql.api_try3.service.TaskService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public String deleteTask(Task task) {
        taskRepository.deleteById(task.getIdTask());
        return "Success";
    }

    @Override
    public Task updateTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task getTask(Long idRoom, String date, String time, String name, String points, String checkBoxes) {
        return taskRepository.findTaskByCriteria(idRoom, date, time, name, points, checkBoxes).stream().findFirst().orElse(null);
    }

    @Override
    public List<Task> getTasks(Long idRoom) {
        return taskRepository.findByIdRoom(idRoom);
    }
}
