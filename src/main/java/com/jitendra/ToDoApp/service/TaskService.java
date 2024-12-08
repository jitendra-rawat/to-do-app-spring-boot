package com.jitendra.ToDoApp.service;

import com.jitendra.ToDoApp.model.Task;
import com.jitendra.ToDoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }


    public void toggleTask(Integer id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));

        // Toggle the completion status
        task.setCompleted(!task.isCompleted());

        // Save the updated task
        taskRepository.save(task);
    }



}
