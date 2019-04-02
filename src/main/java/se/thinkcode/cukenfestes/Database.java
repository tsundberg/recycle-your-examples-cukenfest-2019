package se.thinkcode.cukenfestes;

import java.util.List;

public interface Database {
    void addTask(Name owner, Task task);

    List<Task> getTasks(Name owner);
}
