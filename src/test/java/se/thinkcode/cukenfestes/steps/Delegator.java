package se.thinkcode.cukenfestes.steps;

import se.thinkcode.cukenfestes.steps.adaptors.AdapterFactory;
import se.thinkcode.cukenfestes.steps.adaptors.TodoAdapter;
import se.thinkcode.cukenfestes.todolist.Name;
import se.thinkcode.cukenfestes.todolist.Task;

import java.util.List;

class Delegator {
    private TodoAdapter adapter;
    private Name currentOwner;

    Delegator() {
        AdapterFactory factory = new AdapterFactory();
        adapter = factory.getAdapter();
    }

    void createTodoList(String owner) {
        currentOwner = new Name(owner);
    }

    void addTask(String description) {
        Task task = new Task(description);
        adapter.addTask(currentOwner, task);
    }

    List<Task> getTasks(String ownerName) {
        Name owner = new Name(ownerName);
        return adapter.getTasks(owner);
    }
}
