package steps;

import controllers.ActorController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Actor;
import org.junit.Assert;
import repository.ActorRepository;
import repository.ActorTestRepository;

import java.sql.SQLException;

public class CreateActorSteps {
    private Actor currentActor;
    private ActorTestRepository actorTestRepository;
    private ActorRepository actorRepository;

    public CreateActorSteps() {
        actorTestRepository = new ActorTestRepository();
        actorRepository = new ActorRepository();
    }

    @Given("I create an actor with the first name {string} and the last name {string}")
    public void iCreateAnActorWithTheFirstNameAndTheLastName(String firstName, String lastName) {
        currentActor = new Actor(firstName, lastName, 0.0);
    }

    @When("I submit the actor")
    public void iSubmitTheActor() throws SQLException{
        actorRepository.insert(currentActor);
    }

    @Then("My actor should exist")
    public void myActorShouldExist() throws SQLException{
        Assert.assertTrue(actorTestRepository.getAll().next());
    }

    @Then("My actor should not exist")
    public void myActorShouldNotExist() throws SQLException{
        Assert.assertFalse(actorTestRepository.getAll().next());
    }

}
