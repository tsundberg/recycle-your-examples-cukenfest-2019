package se.thinkcode.cukenfestes.todolist;

import java.util.List;

public interface Database {
    void addTask(Name owner, Task task);

    List<Task> getTasks(Name owner);
}
