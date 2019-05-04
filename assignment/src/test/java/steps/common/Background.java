package steps.common;

import cucumber.api.java.en.Given;

/**
 * Contains steps for testing creating an organisation
 */
public class Background {

    /**
     * Checks that the connection to the database is valid
     */
    @Given("I am connected to the database")
    public void iAmConnectedToTheDatabase() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    /**
     * Empties all tables in the database
     */
    @Given("I reset the database")
    public void iResetTheDatabase() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
