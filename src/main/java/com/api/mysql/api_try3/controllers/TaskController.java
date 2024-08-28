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
        return taskService.getTask(task.getIdRoom(), task.getDate(), task.getTime(), task.getName(), task.getPoints(), task.getCheckBoxes());
    }

    @GetMapping("/get/all/{idRoom}")
    public List<Task> getTaskDetails(@PathVariable("idRoom") Long idRoom) {
        return taskService.getTasks(idRoom);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return task;
    }
    @PutMapping("/update")
    public Task updateEvent(@RequestBody Task task) {
        taskService.updateTask(task);
        return task;
    }


    @DeleteMapping("/delete/{idTask}")
    public String deleteTask(@PathVariable("idTask") Long idTask) {
        taskService.deleteTask(idTask);
        return "Task deleted successfully";
    }

}
