package se.thinkcode.cukenfestes.todolist;

import io.dropwizard.views.View;

import java.util.ArrayList;
import java.util.List;

public class TodoListView extends View {
    private Name owner;
    private List<Task> tasks = new ArrayList<>();

    TodoListView() {
        super("todoList.mustache");
    }

    TodoListView(Name owner, List<Task> tasks) {
        super("todoList.mustache");
        this.owner = owner;
        this.tasks = tasks;
    }

    public Name getOwner() {
        return owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}