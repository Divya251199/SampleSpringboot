package com.example.ToDoApp.services;

import com.example.ToDoApp.repository.TodoDao;
import com.example.ToDoApp.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;


    public List<Todo> getTodos() {
        return todoDao.getTodosFromDataSource();
    }

    public String addMyTodo(Todo todo) {
        boolean insertionStatus = todoDao.save(todo);
        if (insertionStatus) {
            return "Todo added successfully!!!!";
        }
        else {
            return "Failed!!!!.....Todo Not possible..Database error";
        }
    }

    public Todo getTodoBasedOnId(String id)
    {
        List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
        for ( Todo todo : todoListRightNow ) {
            if (todo.getId().equals(id)) { // multiple ids may exist
                return todo;
            }
        }
        return null;
    }


    public String removeTodoById(String id) {
        boolean deleteResponse = false;
        String status;
        if (id != null ) {
            List<Todo> todoListRightNow = todoDao.getTodosFromDataSource();
            for ( Todo todo : todoListRightNow ) {
                if (todo.getId().equals(id)) {
                    deleteResponse = todoDao.remove(todo);
                    if (deleteResponse) {
                        status = "Todo with id" + id + "was deleted";
                    }
                    else {
                        status = "Todo with id" + id + "was not deleted......Database error";
                    }
                    return status;
                }
            }
        }
        return "No element with this id present";
    }




    public String updateTodoStatusById(String id, String status) {
        //I purposely put all the business logic for update in the dao layer...students are supposed to restructure
        boolean updateStatus =  todoDao.update(id,Boolean.parseBoolean(status));

        if(updateStatus)
        {
            return "Todo with id: " + id + " was updated!!!";
        }
        else
        {
            return "Todo with id: " + id + " does not exist!!!";
        }
    }
}
