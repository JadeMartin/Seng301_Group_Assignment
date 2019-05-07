package steps;

import controllers.ActorController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Actor;
import org.junit.Assert;
import repository.ActorRepository;
import repository.ActorTestRepository;
import views.ActorView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateActorSteps {
    private Actor currentActor;
    private ActorTestRepository actorTestRepository;
    private ActorRepository actorRepository;
    private ActorView actorView;
    private Boolean exceptionFlag;

    public CreateActorSteps() {
        actorTestRepository = new ActorTestRepository();
        actorRepository = new ActorRepository();
        actorView = new ActorView();
        exceptionFlag = false;
    }

    @Given("I create an actor with the first name {string} and the last name {string}")
    public void iCreateAnActorWithTheFirstNameAndTheLastName(String firstName, String lastName) {
        try {
            actorView.validateNotNullString(firstName);
            actorView.validateNotNullString(lastName);
        } catch (Exception e) {
            exceptionFlag = true;
        }

        currentActor = new Actor(firstName, lastName);
    }

    @When("I submit the actor")
    public void iSubmitTheActor() throws SQLException{
        actorRepository.insert(currentActor);
    }

    @Then("My actor should exist")
    public void myActorShouldExist() throws SQLException{
        Assert.assertTrue(actorTestRepository.getAll().next());
    }

    @Then("I should be notified that there is an error")
    public void iShouldBeNotifiedThatThereIsAnError() {
        Assert.assertTrue(exceptionFlag);
    }

    @When("I answer {string} to insert duplicate")
    public void iAnswerToInsertDuplicate(String string) {
        try {
            actorView.convertHomonymInput(string);
        } catch (Exception e) {
            exceptionFlag = true;
        }
    }

    @Then("My actor should not exist")
    public void myActorShouldNotExist() throws SQLException {
        Assert.assertFalse(actorTestRepository.getAll().next());
    }

    @Then("Two actors should not exist")
    public void twoActorsShouldNotExist() throws SQLException {
        ResultSet resultSet = actorTestRepository.getAll();
        resultSet.next();
        Assert.assertFalse(resultSet.next());
    }

}
