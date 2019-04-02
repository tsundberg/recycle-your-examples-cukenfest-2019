package se.thinkcode.cukenfestes.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TodoSteps {
    @Given("that {} is out of {}")
    public void that_is_out_of(String name, String item) {
        System.out.println(name);
        System.out.println(item);
    }

    @When("he adds {} to his todo list")
    public void he_adds_a_task_to_his_todo_list(String task) {
        System.out.println(task);
    }

    @Then("should {} todo list contain {}")
    public void should_Thomas_todo_list_contain_buy_cat_food(String name, String expectedTask) {
        System.out.println(name);
        System.out.println(expectedTask);
    }
}
