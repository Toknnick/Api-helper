package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.Task;
import com.api.mysql.api_try3.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/get/one")
    public Task getTaskDetails(@RequestBody Task task) {
        return taskService.getTaskByDate(task.getIdRoom(), task.getDate(), task.getTime(), task.getName(), task.getPoints(), task.getCheckBoxes());
    }

    @GetMapping("/get/all/{idRoom}")
    public List<Task> getTaskDetails(@PathVariable("idRoom") Long idRoom) {
        return taskService.getTasks(idRoom);
    }

    @PostMapping("/create")
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task created successfully";
    }

    @DeleteMapping("/delete")
    public String deleteTask(@RequestBody Task tempTask) {
        Task task = taskService.getTaskByDate(tempTask.getIdRoom(), tempTask.getDate(), tempTask.getTime(), tempTask.getName(), tempTask.getPoints(), tempTask.getCheckBoxes());
        if(task != null) {
            taskService.deleteTask(task);
            return "Task deleted successfully";
        }else{
            return "Task does not exist";
        }
    }

}
