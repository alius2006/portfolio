package com.dockerProject.steps;

import com.dockerProject.data.PersonRepository;
import com.dockerProject.dto.Person;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Steps {

    @Autowired
    private PersonRepository personRepository;

    @When("Method when")
    public void when() {
        System.out.println("test one two");
//        Person person = new Person();
//        person.setFirstName("Karel");
//        person.setLastName("Korinek");
//        personRepository.savePerson(person);
    }

    @Then("Method then")
    public void then() {
        System.out.println("!!!Test was successful!!!");
    }
}
