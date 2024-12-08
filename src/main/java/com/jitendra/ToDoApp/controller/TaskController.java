package com.jitendra.ToDoApp.controller;

import com.jitendra.ToDoApp.model.Task;
import com.jitendra.ToDoApp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Simplifies the controller for RESTful APIs (returns JSON by default)
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    // Constructor-based dependency injection
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all-tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks(); // Return tasks as JSON
    }


    @PostMapping("/create-task")
    public String createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return "Task created successfully!";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
        return "Task has been deleted successfully";
    }


    @PostMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Integer id) {
        taskService.toggleTask(id);
        return "Task completion status has been toggled successfully";
    }



}
