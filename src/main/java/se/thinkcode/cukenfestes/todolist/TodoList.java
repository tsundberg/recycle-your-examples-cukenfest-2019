package se.thinkcode.cukenfestes.todolist;

import java.util.ArrayList;
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
        List<Task> tasks = database.getTasks(owner);

        if (tasks == null) {
            return new ArrayList<>();
        } else {
            return tasks;
        }
    }
}
