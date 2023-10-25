package com.TodoList.TodoListApp.Controllers;

import com.TodoList.TodoListApp.Dto.request.TaskRequest;
import com.TodoList.TodoListApp.Dto.response.TaskResponse;
import com.TodoList.TodoListApp.Services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @PostMapping("create")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest){
        TaskResponse taskResponse = taskService.createTask(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @GetMapping("get_all")
    public ResponseEntity<List<TaskResponse>> getAllTask(){
        List<TaskResponse> taskResponses = taskService.getAllTask();
        return ResponseEntity.ok(taskResponses);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id){
        TaskResponse taskResponse = taskService.getTaskById(id);
        return ResponseEntity.ok(taskResponse);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody TaskRequest taskRequest, @PathVariable Long id){
        TaskResponse taskResponse = taskService.updateTask(taskRequest, id);
        return ResponseEntity.ok(taskResponse);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        taskService.deleteTaskId(id);
        return ResponseEntity.ok("Task delete successfully");
    }
}
