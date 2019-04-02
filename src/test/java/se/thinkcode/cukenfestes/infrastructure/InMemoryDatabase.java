package se.thinkcode.cukenfestes.infrastructure;

import se.thinkcode.cukenfestes.Database;
import se.thinkcode.cukenfestes.Name;
import se.thinkcode.cukenfestes.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabase implements Database {
    private Map<Name, List<Task>> allTasks = new HashMap<>();

    @Override
    public void addTask(Name owner, Task task) {
        List<Task> tasks = allTasks.getOrDefault(owner, new ArrayList<>());
        tasks.add(task);

        allTasks.put(owner, tasks);
    }

    @Override
    public List<Task> getTasks(Name owner) {
        return allTasks.getOrDefault(owner, new ArrayList<>());
    }
}
