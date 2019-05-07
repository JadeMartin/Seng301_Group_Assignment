package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Actor;
import models.Argument;
import models.ArgumentLink;
import org.junit.Assert;
import repository.ActorRepository;
import repository.ArgumentRepository;
import views.ArgumentView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArgumentLinkSteps {

    private ArgumentLink currentArgumentLink;
    private ArgumentView argumentView;
    private ArgumentRepository argumentRepository;

    private boolean exceptionFlag;

    public ArgumentLinkSteps() {
        argumentView = new ArgumentView();
        argumentRepository = new ArgumentRepository();
        exceptionFlag = false;
    }

    @Given("I insert two arguments in the database")
    public void iInsertTwoArgumentsInTheDatabase() throws SQLException {

        ActorRepository actorRepository = new ActorRepository();
        actorRepository.insert(new Actor("first", "last"));

        argumentRepository.insert(new Argument(1, 1, "phrase", 1, 2));
        argumentRepository.insert(new Argument(1, 1, "new phrase", 4, 5));


        ResultSet resultSet = argumentRepository.getAll();
        resultSet.next();
        Assert.assertTrue(resultSet.next());
    }

    @Given("I create an argument link by inputting {string} for argument one and {string} for argument two with argument type {string}")
    public void iCreateAnArgumentLinkByInputtingForArgumentAndForArgumentWithArgumentType(String arg1String, String arg2String, String argTypeString) {
        try {
            System.out.println("here0");
            int arg1 = argumentView.convertToOption(arg1String, "argument", "argument_id");
            System.out.println("here1");
            int arg2 = argumentView.convertToOption(arg2String, "argument", "argument_id");
            System.out.println("here2");
            boolean argType = argumentView.convertToBool(argTypeString);
            System.out.println("here3");

            currentArgumentLink = new ArgumentLink(arg1, arg2, argType);
        } catch (Exception e) {
            exceptionFlag = true;
        }
    }

    @When("I submit the argument link")
    public void iSubmitTheArgumentLink() throws SQLException {
        if (!exceptionFlag) {
            argumentRepository.insertLink(currentArgumentLink);
        }
    }

    @Then("My argument link should exist")
    public void myArgumentLinkShouldExist() throws SQLException {
        Assert.assertTrue(argumentRepository.getAllByTableName("argument_link").next());
    }

    @Then("I should be notified with an incorrect argument link error")
    public void iShouldBeNotifiedWithAnIncorrectArgumentLinkError() {
        Assert.assertTrue(exceptionFlag);
    }

}
