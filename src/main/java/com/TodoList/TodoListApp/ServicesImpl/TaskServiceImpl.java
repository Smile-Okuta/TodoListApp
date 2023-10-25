package com.TodoList.TodoListApp.ServicesImpl;

import com.TodoList.TodoListApp.Dto.request.TaskRequest;
import com.TodoList.TodoListApp.Dto.response.TaskResponse;
import com.TodoList.TodoListApp.Models.TaskModel;
import com.TodoList.TodoListApp.Repository.TaskRepository;
import com.TodoList.TodoListApp.Services.TaskService;
import com.TodoList.TodoListApp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        TaskModel taskModel = new TaskModel();
        taskModel.setName(taskRequest.getName());
        taskModel.setCategoryName(taskRequest.getCategoryName());

        TaskModel savedTaskModel = taskRepository.save(taskModel);
        return mapToTaskResponse(savedTaskModel);

    }



    @Override
    public List<TaskResponse> getAllTask() {
        List<TaskModel> taskModels = taskRepository.findAll();
        List<TaskResponse> taskResponses = new ArrayList<>();
        for(TaskModel taskModel: taskModels){
            TaskResponse taskResponse = mapToTaskResponse(taskModel);
            taskResponses.add(taskResponse);
        }
        return taskResponses;

//        return taskRepository.findAll()
//                .stream()
//                .map(taskModel -> mapToTaskResponse(taskModel))
//                .collect(Collectors.toList());
    }


    @Override
    public TaskResponse getTaskById(Long id) {
        TaskModel taskModel = findTaskById(id);
        return mapToTaskResponse(taskModel);

//        return taskRepository.findById(id)
//                .map(taskModel -> mapToTaskResponse(taskModel))
//                .orElseThrow(()-> new NotFoundException("Task not found."));
    }


    @Override
    public TaskResponse updateTask(TaskRequest taskRequest, Long id) {
        TaskModel taskModel = findTaskById(id);
        taskModel.setName(taskRequest.getName());
        taskModel.setCategoryName(taskRequest.getCategoryName());
        TaskModel savedTaskModel = taskRepository.save(taskModel);
        return mapToTaskResponse(savedTaskModel);
    }

    @Override
    public void deleteTaskId(Long id) {
        TaskModel taskModel = findTaskById(id);
        taskRepository.delete(taskModel);
    }

    private TaskResponse mapToTaskResponse(TaskModel taskModel){
        return TaskResponse.builder()
                .id(taskModel.getId())
                .name(taskModel.getName())
                .categoryName(taskModel.getCategoryName())
                .createdAt(taskModel.getCreatedAt())
                .build();
    }

    private TaskModel findTaskById(Long id){
        return  taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
    }


}
