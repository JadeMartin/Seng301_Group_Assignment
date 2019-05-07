package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Actor;
import models.Argument;
import models.Organisation;
import org.junit.Assert;
import repository.ActorRepository;
import repository.ArgumentRepository;
import repository.OrganisationRepository;
import views.ArgumentView;

import java.sql.SQLException;

public class CreateArgumentSteps {

    private Argument currentArgument;
    private ArgumentView argumentView;
    private ArgumentRepository argumentRepository;

    private boolean exceptionFlag;

    public CreateArgumentSteps() {
        argumentView = new ArgumentView();
        argumentRepository = new ArgumentRepository();
        exceptionFlag = false;
    }

    @Given("I have inserted an actor, discourse and source")
    public void iHaveInsertedAnActorDiscourseAndSource() throws SQLException {
        Actor actor = new Actor("first", "last");
        ActorRepository actorRepository = new ActorRepository();
        actorRepository.insert(actor);

        // One discourse and one source is already in the database
    }

    @Given("I create an argument with the actor {string}, source {string}, discourse {string}, rephrasing {string}, start index {string}, end index {string}")
    public void iCreateAnArgumentWithTheActorSourceDiscourseRephrasingStartIndexEndIndex(String actorString, String sourceString, String discourseString, String rephraseString, String startIndexString, String endIndexString) {
        try {
            int actor = argumentView.convertToOption(actorString, "actor", "actor_id");
            int source = argumentView.convertToOption(sourceString, "source", "source_id");
            int discourse = argumentView.convertToOption(discourseString, "discourse", "discourse_id");
            argumentView.validateNotNullString(rephraseString);
            argumentView.convertTo(startIndexString);
            int startIndex = argumentView.convertTo(startIndexString);
            int endIndex = argumentView.convertTo(endIndexString);
            argumentView.validateIndexOrder(startIndex, endIndex);

            currentArgument = new Argument(discourse, actor, rephraseString, startIndex, endIndex);

        } catch (Exception e) {
            exceptionFlag = true;
        }
    }

    @When("I submit the argument")
    public void iSubmitTheArgument() throws SQLException {
        argumentRepository.insert(currentArgument);
    }

    @Then("My argument should exist")
    public void myArgumentShouldExist() throws SQLException {
        Assert.assertTrue(argumentRepository.getAll().next());
    }

    @Then("I should be notified with an incorrect argument error")
    public void iShouldBeNotifiedWithAnIncorrectArgumentError() {
        Assert.assertTrue(exceptionFlag);
    }
}
