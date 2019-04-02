package se.thinkcode.cukenfestes.steps;

import se.thinkcode.cukenfestes.Task;

import java.util.List;

class Delegator {
    void createTodoList(String name) {
        throw new RuntimeException("Not yet implemented");
    }

    void addTask(String task) {
        throw new RuntimeException("Not yet implemented");
    }

    List<Task> getTasks(String name) {
        throw new RuntimeException("Not yet implemented");
    }
}
