package com.TodoList.TodoListApp.Repository;

import com.TodoList.TodoListApp.Models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
