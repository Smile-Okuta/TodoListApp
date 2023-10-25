package com.TodoList.TodoListApp.Services;

import com.TodoList.TodoListApp.Dto.request.TaskRequest;
import com.TodoList.TodoListApp.Dto.response.TaskResponse;
import com.TodoList.TodoListApp.Models.TaskModel;
import java.util.List;

public interface TaskService {
    TaskResponse createTask(TaskRequest taskRequest);

    List<TaskResponse>getAllTask();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    void deleteTaskId(Long id);

}
