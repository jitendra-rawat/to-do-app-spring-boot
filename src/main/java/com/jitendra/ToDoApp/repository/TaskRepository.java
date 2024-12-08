package com.jitendra.ToDoApp.repository;

import com.jitendra.ToDoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
