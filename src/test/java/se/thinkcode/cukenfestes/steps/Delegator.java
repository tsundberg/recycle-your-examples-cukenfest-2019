package se.thinkcode.cukenfestes.steps;

import se.thinkcode.cukenfestes.Name;
import se.thinkcode.cukenfestes.Task;

import java.util.List;

class Delegator {
    private TodoAdapter adapter;
    private Name currentOwner;

    void createTodoList(String owner) {
        currentOwner = new Name(owner);

        adapter.createList(currentOwner);
    }

    void addTask(String description) {
        Task task = new Task(description);
        adapter.addTask(currentOwner, task);
    }

    List<Task> getTasks(String name) {
        return adapter.getTasks(currentOwner);
    }
}
