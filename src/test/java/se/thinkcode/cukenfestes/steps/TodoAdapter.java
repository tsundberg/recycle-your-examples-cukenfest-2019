package se.thinkcode.cukenfestes.steps;

import se.thinkcode.cukenfestes.Name;
import se.thinkcode.cukenfestes.Task;

import java.util.List;

public interface TodoAdapter {
    void createList(Name owner);

    void addTask(Name owner, Task task);

    List<Task> getTasks(Name owner);
}
