package steps.organisation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Contains steps for testing creating an organisation
 */
public class createOrganisation {

    /**
     * Sets the organisation's name to the given string
     * @param string The organisation's name
     */
    @Given("I provide the organisation name {string}")
    public void iProvideTheOrganisationName(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    /**
     * Calls the organisation insert handler to test inserting into the database
     */
    @When("I submit the organisation")
    public void iSubmitTheOrganisation() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    /**
     * Checks if the submitted organisation now exists in the database
     */
    @Then("The organisation should exist")
    public void theOrganisationShouldExist() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    /**
     * Checks if the submitted organisation does not exist in the database
     */
    @Then("the organisation should not exist")
    public void theOrganisationShouldNotExist() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    /**
     * Inserts a given organisation into the database
     * @param string The organisation's name
     */
    @Given("The organisation {string} exists in the database")
    public void theOrganisationExistsInTheDatabase(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    /**
     * Checks if an exception was thrown
     */
    @Then("An exception should be thrown")
    public void anExceptionShouldBeThrown() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
