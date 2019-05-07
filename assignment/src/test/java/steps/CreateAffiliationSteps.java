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
import views.ActorView;
import views.AffiliationView;
import views.OrganisationView;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAffiliationSteps {

    private Affiliation currentAffiliation;
    private ActorView actorView;
    private OrganisationView organisationView;
    private AffiliationView affiliationView;
    private AffiliationController affiliationController;

    private  boolean exceptionFlag;

    public CreateAffiliationSteps() {
        actorView = new ActorView();
        organisationView = new OrganisationView();
        affiliationView = new AffiliationView();
        affiliationController = new AffiliationController();

        exceptionFlag = false;
    }

    @Given("I have inserted an actor and organisation")
    public void iHaveInsertedAnActorAndOrganisation() throws SQLException {
        Actor actor = new Actor("first", "last");
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

    @Given("I create an affiliation with the actor {string}, organisation {string}, role {string}, start date {string}, end date {string}")
    public void iCreateAnAffiliationWithTheActorOrganisationRoleStartDateEndDate(String actorString, String organisationString, String roleString, String startDateString, String endDateString) {
        try {
            int actor = actorView.convertToOption(actorString.equals("") ? null : actorString, "actor", "actor_id");
            Integer organisation = organisationView.convertToOrgOption(organisationString.equals("") ? null : organisationString);
            Date startDate = affiliationView.convertToDate(startDateString.equals("") ? null : startDateString);
            Date endDate = affiliationView.convertToDate(endDateString.equals("") ? null : endDateString);
            affiliationController.validateDates(startDate, endDate);

            currentAffiliation = new Affiliation(actor, organisation, roleString, startDate, endDate);
        } catch (Exception e) {
            exceptionFlag = true;
        }
    }

    @Then("I should be notified with an incorrect affiliation error")
    public void iShouldBeNotifiedWithAnIncorrectAffiliationError() {
        Assert.assertTrue(exceptionFlag);
    }

    @When("I submit the affiliation")
    public void iSubmitTheAffiliation() throws SQLException{
        AffiliationController affiliationController = new AffiliationController();
        affiliationController.insertAffiliation(currentAffiliation);
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
