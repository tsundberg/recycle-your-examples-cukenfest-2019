package se.thinkcode.cukenfestes.steps.adaptors;

import se.thinkcode.cukenfestes.todolist.Database;
import se.thinkcode.cukenfestes.todolist.Name;
import se.thinkcode.cukenfestes.todolist.Task;
import se.thinkcode.cukenfestes.todolist.TodoList;

import java.util.List;

public class ModelAdaptor implements TodoAdapter {
    private TodoList todoList;

    ModelAdaptor(Database database) {
        todoList = new TodoList(database);
    }

    @Override
    public void addTask(Name owner, Task task) {
        todoList.addTask(owner, task);
    }

    @Override
    public List<Task> getTasks(Name owner) {
        return todoList.getTasks(owner);
    }
}
