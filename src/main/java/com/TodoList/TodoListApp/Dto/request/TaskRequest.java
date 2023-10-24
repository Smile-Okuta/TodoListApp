package com.TodoList.TodoListApp.Dto.request;

import com.TodoList.TodoListApp.Enum.CategoryName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private String name;
    private CategoryName categoryName;
}
