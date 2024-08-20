package com.api.mysql.api_try3.service.imlp;

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
    public String createTask(Task task) {
        taskRepository.save(task);
        return "Success";
    }

    @Override
    public String updateTask(Task task) {
        taskRepository.save(task);
        return "Success";
    }

    @Override
    public String deleteTask(Task task) {
        taskRepository.deleteById(task.getIdTask());
        return "Success";
    }

    @Override
    public Task getTaskByDate(Long idRoom, Date date, String time, String name, String points, String checkBoxes) {
        return taskRepository.findTaskByCriteria(idRoom, date, time, name, points, checkBoxes).get(0);
    }

    @Override
    public List<Task> getTasks(Long idRoom) {
        return taskRepository.findByIdRoom(idRoom);
    }
}
