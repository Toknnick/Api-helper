package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Event;
import com.api.mysql.api_try3.models.Task;
import com.api.mysql.api_try3.repository.TaskRepository;
import com.api.mysql.api_try3.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Transactional
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
    public String deleteTask(int idTask) {
        taskRepository.deleteById(idTask);
        return "Success";
    }

    @Override
    public Task updateTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task getTask(int idRoom, String date, String time, String name, String points, String checkBoxes) {
        return taskRepository.findTaskByCriteria(idRoom, date, time, name, points, checkBoxes).stream().findFirst().orElse(null);
    }

    @Override
    public List<Task> getTasksByIdRoom(int idRoom) {
        return taskRepository.findByIdRoom(idRoom);
    }
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
