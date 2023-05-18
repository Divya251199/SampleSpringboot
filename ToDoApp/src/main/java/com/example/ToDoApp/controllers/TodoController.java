package com.example.ToDoApp.controllers;

import com.example.ToDoApp.services.TodoService;
import com.example.ToDoApp.models.Todo;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/toDo")
    public List<Todo> getTodos(@Nullable @RequestParam String lastDate) {
        return todoService.getTodos();
    }

    @PostMapping(value = "/toDo")
    public String addTodo(@RequestBody Todo todo) {
        return todoService.addMyTodo(todo);
    }

    @RequestMapping(value = "/getTodoById/{id}", method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id)
    {
        return todoService.getTodoBasedOnId(id);
    }

    // Create a delete endpoint
    @DeleteMapping(value = "/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id) {
        return todoService.removeTodoById(id);
    }

    // updation of todo
    @PutMapping(value = "/updateTodoById/{id}/{status}")
    public String updateTodoStatusById(@PathVariable String id, @PathVariable String status)
    {
        return todoService.updateTodoStatusById(id,status);
    }
}
