package se.thinkcode.cukenfestes;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.thinkcode.cukenfestes.todolist.Database;
import se.thinkcode.cukenfestes.todolist.TodoList;
import se.thinkcode.cukenfestes.todolist.TodoResource;

public class Main extends Application<Configuration> {
    private Database database;

    public static void main(String... args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "The ToDo List";
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        database = getDatabase();
        TodoList todoList = new TodoList(database);
        TodoResource todoResource = new TodoResource(todoList);

        environment.jersey().register(todoResource);
    }

    private Database getDatabase() {
        if (database == null) {
            return null;
        }

        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
