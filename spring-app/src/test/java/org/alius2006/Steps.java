package org.alius2006;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class Steps {

    @Autowired
    MyComponent myComponent;

    private int a;

    @When("Test when")
    public void when() {
        a = 20;
        System.out.println("\"a\" was set to 20");
        String text = myComponent.getText();
        System.out.println("This is my text: " + text);
    }

    @Then("Test then")
    public void then() {
        assert 20 == a;
        System.out.println("\"a\" is equal to 20");
    }
}
