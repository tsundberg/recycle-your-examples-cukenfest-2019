package se.thinkcode.cukenfestes.steps.adaptors;

import se.thinkcode.cukenfestes.Name;
import se.thinkcode.cukenfestes.Task;
import se.thinkcode.cukenfestes.TodoList;
import se.thinkcode.cukenfestes.infrastructure.InMemoryDatabase;

import java.util.List;

public class ModelAdaptor implements TodoAdapter {
    private TodoList todoList;

    @Override
    public void createList(Name owner) {
        InMemoryDatabase database = new InMemoryDatabase();
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
