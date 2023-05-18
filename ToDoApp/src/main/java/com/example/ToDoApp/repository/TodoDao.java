package com.example.ToDoApp.repository;

import com.example.ToDoApp.models.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {

    private List<Todo> todoList;

    public TodoDao() {
        todoList = new ArrayList<>();
    }

    public List<Todo> getTodosFromDataSource() {
        return todoList;
    }

    public boolean save(Todo todo) {
        todoList.add(todo); // mock database call
        return true;
    }

    public boolean remove(Todo todo) {
        todoList.remove(todo); // mock database call
        return true;
    }

    public boolean update(String id, boolean status) {
        boolean updateStatus = false;
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                //my simple update logic
                //remove original :
                remove(todo);

                //change this todo now
                todo.setTodoStatus(status);

                //add this new todo :
                save(todo);

                //todo.setTodoStatus(status);


            }

        }

        return updateStatus;
    }
}