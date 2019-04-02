package se.thinkcode.cukenfestes.steps;

import se.thinkcode.cukenfestes.Name;
import se.thinkcode.cukenfestes.Task;
import se.thinkcode.cukenfestes.TodoList;

import java.util.List;

public class ModelAdaptor implements TodoAdapter {
    private TodoList todoList;

    @Override
    public void createList(Name owner) {
        todoList = new TodoList();
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
