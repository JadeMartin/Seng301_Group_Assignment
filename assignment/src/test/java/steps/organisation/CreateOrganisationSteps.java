package steps.organisation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Organisation;
import org.junit.Assert;
import repository.OrganisationTestRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Contains steps for testing creating an organisation
 */
public class CreateOrganisationSteps {

    private OrganisationTestRepository organisationTestRepository;
    private Organisation currentOrganisation;
    private boolean exceptionFlag;

    /**
     * Constructor
     */
    public CreateOrganisationSteps() {
        organisationTestRepository = new OrganisationTestRepository();
        exceptionFlag = false;
    }

    /**
     * Sets the organisation's name to the given string
     * @param name The organisation's name
     */
    @Given("I create an organisation with the name {string}")
    public void iProvideTheOrganisationName(String name) {
        currentOrganisation = new Organisation(name);
    }

    /**
     * Calls the organisation insert handler to test inserting into the database
     */
    @When("I submit the organisation")
    public void iSubmitTheOrganisation() {
        try {
            organisationTestRepository.insert(currentOrganisation);
        } catch (SQLException e) {
            exceptionFlag = true;
        }
    }

    /**
     * Checks if the submitted organisation now exists in the database
     */
    @Then("My organisation should exist")
    public void theOrganisationShouldExist() throws SQLException {
        ResultSet organisationResultSet = organisationTestRepository.getByName(currentOrganisation.getOrganisationName());
        String newOrgName = organisationResultSet.getString("name");
        organisationResultSet.close();
        Assert.assertTrue(!exceptionFlag && newOrgName.equals(currentOrganisation.getOrganisationName()));
    }

    /**
     * Checks if the submitted organisation now exists in the database
     */
    @Then("My organisation should not exist")
    public void theOrganisationShouldNotExist() throws SQLException {
        ResultSet organisationResultSet = organisationTestRepository.getByName(currentOrganisation.getOrganisationName());
        Assert.assertFalse(organisationResultSet.next());
    }

    /**
     * Checks if an exception was thrown
     */
    @Then("An exception should be thrown")
    public void anExceptionShouldBeThrown() {
        Assert.assertTrue(exceptionFlag);
    }
}
