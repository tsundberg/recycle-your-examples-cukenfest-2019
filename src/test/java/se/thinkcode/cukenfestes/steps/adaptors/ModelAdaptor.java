package se.thinkcode.cukenfestes.steps.adaptors;

import se.thinkcode.cukenfestes.todolist.Database;
import se.thinkcode.cukenfestes.todolist.Owner;
import se.thinkcode.cukenfestes.todolist.Task;
import se.thinkcode.cukenfestes.todolist.TodoList;

import java.util.List;

public class ModelAdaptor implements TodoAdapter {
    private TodoList todoList;

    ModelAdaptor(Database database) {
        todoList = new TodoList(database);
    }

    @Override
    public void addTask(Owner owner, Task task) {
        todoList.addTask(owner, task);
    }

    @Override
    public List<Task> getTasks(Owner owner) {
        return todoList.getTasks(owner);
    }
}
