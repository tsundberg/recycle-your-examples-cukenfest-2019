package se.thinkcode.cukenfestes.todolist;

import java.util.List;

public class TodoList {
    private Database database;

    public TodoList(Database database) {
        this.database = database;
    }

    public void addTask(Name owner, Task task) {
        database.addTask(owner, task);
    }

    public List<Task> getTasks(Name owner) {
        return database.getTasks(owner);
    }
}
