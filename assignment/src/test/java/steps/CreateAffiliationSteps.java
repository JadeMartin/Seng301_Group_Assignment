package steps;

import controllers.AffiliationController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Actor;
import models.Affiliation;
import models.Organisation;
import org.junit.Assert;
import repository.ActorRepository;
import repository.AffiliationRepository;
import repository.AffiliationTestRepository;
import repository.OrganisationRepository;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateAffiliationSteps {

    private Affiliation currentAffiliation;

    @Given("I have inserted an actor and organisation")
    public void iHaveInsertedAnActorAndOrganisation() throws SQLException {
        Actor actor = new Actor("first", "last", 0.0);
        ActorRepository actorRepository = new ActorRepository();
        actorRepository.insert(actor);

        Organisation organisation = new Organisation("organisation");
        OrganisationRepository organisationRepository = new OrganisationRepository();
        organisationRepository.insert(organisation);
    }

    @Given("I create an affiliation with the actor {int}, organisation {int}, role {string}, start date {string}, end date {string}")
    public void iCreateAnAffiliationWithTheActorOrganisationRoleStartDateEndDate(Integer actorId, Integer organisationId, String role, String startDate, String endDate) throws ParseException {
        currentAffiliation = new Affiliation(actorId, organisationId, role, new SimpleDateFormat("dd/MM/yyyy").parse(startDate), new SimpleDateFormat("dd/MM/yyyy").parse(endDate));
    }

    @When("I submit the affiliation")
    public void iSubmitTheAffiliation() throws SQLException{
        AffiliationRepository affiliationRepository = new AffiliationRepository();
        affiliationRepository.insert(currentAffiliation);
    }

    @Then("My affiliation should exist")
    public void myAffiliationShouldExist() throws SQLException{
        AffiliationTestRepository affiliationTestRepository = new AffiliationTestRepository();
        Assert.assertTrue(affiliationTestRepository.getAll().next());
    }

    @Then("My affiliation should not exist")
    public void myAffiliationShouldNotExist() throws SQLException{
        AffiliationTestRepository affiliationTestRepository = new AffiliationTestRepository();
        Assert.assertFalse(affiliationTestRepository.getAll().next());
    }
}
