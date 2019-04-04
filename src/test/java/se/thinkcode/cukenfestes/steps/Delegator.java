package se.thinkcode.cukenfestes.steps;

import se.thinkcode.cukenfestes.steps.adaptors.AdapterFactory;
import se.thinkcode.cukenfestes.steps.adaptors.TodoAdapter;
import se.thinkcode.cukenfestes.todolist.Owner;
import se.thinkcode.cukenfestes.todolist.Task;

import java.util.List;

class Delegator {
    private TodoAdapter adapter;
    private Owner currentOwner;

    Delegator() {
        AdapterFactory factory = new AdapterFactory();
        adapter = factory.getAdapter();
    }

    void createTodoList(String owner) {
        currentOwner = new Owner(owner);
    }

    void addTask(String description) {
        Task task = new Task(description);
        adapter.addTask(currentOwner, task);
    }

    List<Task> getTasks(String ownerName) {
        Owner owner = new Owner(ownerName);
        return adapter.getTasks(owner);
    }

    void cleanUp() {
        adapter.cleanUp();
    }
}
