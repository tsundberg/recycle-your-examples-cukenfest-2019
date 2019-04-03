package se.thinkcode.cukenfestes.steps.adaptors;

import se.thinkcode.cukenfestes.todolist.Name;
import se.thinkcode.cukenfestes.todolist.Task;

import java.util.List;

public interface TodoAdapter {
    void addTask(Name owner, Task task);

    List<Task> getTasks(Name owner);
}
