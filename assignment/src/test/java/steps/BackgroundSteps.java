package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import repository.BackgroundTestRepository;

import java.sql.SQLException;

/**
 * Contains steps for testing creating an organisation
 */
public class BackgroundSteps {

    BackgroundTestRepository backgroundTestRepository;

    /**
     * Constructor
     */
    public BackgroundSteps() {
        backgroundTestRepository = new BackgroundTestRepository();
    }

    /**
     * Checks that the connection to the database is valid
     */
    @Given("I am connected to the database")
    public void iAmConnectedToTheDatabase() {
        Assert.assertNotEquals(backgroundTestRepository.getConnection(), null);
    }

    /**
     * Empties all tables in the database
     */
    @When("I reset the database")
    public void iResetTheDatabase() throws SQLException {
        backgroundTestRepository.reset();
    }

    /**
     * Checks if the database is empty
     */
    @Then("The database should be empty")
    public void theDatabaseShouldBeEmpty() throws SQLException {
        Assert.assertFalse(backgroundTestRepository.getAllByTableName("organisation").next());

    }
}
