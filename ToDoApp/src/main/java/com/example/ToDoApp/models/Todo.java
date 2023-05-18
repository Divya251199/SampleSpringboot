package com.example.ToDoApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {
    private String id;
    @JsonProperty("todoname")
    private String todoName ;
    private boolean todoStatus;
    private String lastDate;


    public Todo(String id, String todoName, boolean todoStatus, String lastDate) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
        this.lastDate = lastDate;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public boolean isTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(boolean todoStatus) {
        this.todoStatus = todoStatus;
    }


    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

}
