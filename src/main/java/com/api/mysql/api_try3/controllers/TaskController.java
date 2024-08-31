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


    @GetMapping("/get/one/{idRoom}/{date}/{time}/{name}/{points}/{checkBoxes}")
    public Task getTaskDetails(@PathVariable("idRoom") Long idRoom,@PathVariable("date") String date,@PathVariable("time")String time
            ,@PathVariable("name") String name,@PathVariable("points") String points, @PathVariable("checkBoxes") String checkBoxes) {
        return taskService.getTask(idRoom, date, time, name, points, checkBoxes);
    }

    @GetMapping("/get/all/{idRoom}")
    public List<Task> getTasksByIdRoom(@PathVariable("idRoom") Long idRoom) {
        return taskService.getTasksByIdRoom(idRoom);
    }

    @GetMapping("/get/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
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
