package se.thinkcode.cukenfestes.steps.adaptors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.JerseyClientBuilder;
import se.thinkcode.cukenfestes.Main;
import se.thinkcode.cukenfestes.todolist.Database;
import se.thinkcode.cukenfestes.todolist.Name;
import se.thinkcode.cukenfestes.todolist.Task;
import se.thinkcode.cukenfestes.todolist.TodoItem;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RestAdaptor implements TodoAdapter {
    private String targetUrl = "http://localhost:8080";

    RestAdaptor(Database database) {
        startApplication(database);
    }

    private void startApplication(Database database) {
        try {
            Main main = new Main();
            main.setDatabase(database);

            String[] arguments = {"server"};
            main.run(arguments);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addTask(Name owner, Task task) {
        Client jerseyClient = JerseyClientBuilder.createClient();
        TodoItem todoItem = new TodoItem(owner, task);
        String json = convertToJson(todoItem);

        Entity<String> todoItemEntity = Entity.entity(json, MediaType.APPLICATION_JSON_TYPE);

        int actual = jerseyClient
                .target(targetUrl)
                .path("/todo")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(todoItemEntity)
                .getStatus();

        assertThat(actual).isEqualTo(Response.Status.CREATED.getStatusCode());
    }

    @Override
    public List<Task> getTasks(Name owner) {
        Client jerseyClient = JerseyClientBuilder.createClient();

        return jerseyClient
                .target(targetUrl)
                .path("/todo/" + owner.getName())
                .request()
                .get(new GenericType<List<Task>>() {
                });
    }

    private String convertToJson(TodoItem todoItem) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(todoItem);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
