package se.thinkcode.cukenfestes.steps.adaptors;

import se.thinkcode.cukenfestes.todolist.Owner;
import se.thinkcode.cukenfestes.todolist.Task;

import java.util.List;

public interface TodoAdapter {
    void addTask(Owner owner, Task task);

    List<Task> getTasks(Owner owner);

    void cleanUp();
}
