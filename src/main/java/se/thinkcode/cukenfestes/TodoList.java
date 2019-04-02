package se.thinkcode.cukenfestes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoList {
    private Map<Name, List<Task>> allTasks = new HashMap<>();

    public void addTask(Name owner, Task task) {
        List<Task> tasks = allTasks.getOrDefault(owner, new ArrayList<>());
        tasks.add(task);

        allTasks.put(owner, tasks);
    }

    public List<Task> getTasks(Name owner) {
        return allTasks.getOrDefault(owner, new ArrayList<>());
    }
}
