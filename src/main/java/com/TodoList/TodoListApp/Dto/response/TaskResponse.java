package com.TodoList.TodoListApp.Dto.response;

import com.TodoList.TodoListApp.Enum.CategoryName;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class TaskResponse {
    private Long id;
    private String name;
    private CategoryName categoryName;
    private LocalDateTime createdAt;
}
