package controllers;

import repository.ActorRepository;
import repository.AffiliationRepository;
import views.ActorView;
import models.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorController {
    private ActorView actorView;
    private ActorRepository actorRepository;
    private AffiliationRepository affiliationRepository;

    /**
     * Constructor
     */
    public ActorController() {
        actorView = new ActorView();
        actorRepository = new ActorRepository();
        affiliationRepository = new AffiliationRepository();
    }

    /**
     * Inserts an Actor by:
     * - Asking for the actor first name and last name * Mandatory
     * - Asking for levelOfTrust not mandatory default to 0
     * - Inserting the Actor into the database.db
     * - If there is a duplicate Name: display confirmation for homonym actor
     * - If all successful store in database
     *   otherwise display success message
     */
    public void insertActor() {
        // Get and validate first name
        String actorFirstName = actorView.getFirstName();
        try {
            actorView.validateNotNullString(actorFirstName);
        } catch (Exception e) {
            actorView.displayIncorrectInput();
            return;
        }

        // Get and validate last name
        String actorLastName = actorView.getLastName();
        try {
            actorView.validateNotNullString(actorLastName);
        } catch (Exception e) {
            actorView.displayIncorrectInput();
            return;
        }

        Actor actor = new Actor(actorFirstName, actorLastName);

        // Try to insert actor and display message based on success
        try {
            insertIfNotHomonym(actor);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Insert an actor if it is registered to not be a homonym
     * @param actor takes in a actor java class and inserts in to database
     */
    public void insertIfNotHomonym(Actor actor) throws SQLException{
        if (!askIfHomonym(actor)) {
            actorRepository.insert(actor);
            actorView.displaySuccessMessage();
        } else {
            actorView.displayNotHomonymMessage();
        }
    }

    /**
     * Function to ask user whether the inputted actor is original or is a homonym
     * Firs outputs all affiliations of the actor then asks for user input
     * @return boolean depending on if the actor is to be accepted or not
     */
    private boolean askIfHomonym(Actor actor) throws SQLException, RuntimeException {
        boolean isHomonym;
        ResultSet actorSet = actorRepository.getAllByFirstAndLast(actor.getFirstName(), actor.getLastName());

        while(actorSet.next()) {
            // Get and validate whether the actor is the same
            ResultSet affiliationSet = affiliationRepository.getAffiliations(actorSet.getInt("actor_id"));
            actorView.askIfHomonym(actorSet.getString("first_name"), actorSet.getString("last_name"), affiliationSet);
        }
        String homonymInput = actorView.getHomonym(actor.getFirstName(), actor.getLastName());
        isHomonym = actorView.convertHomonymInput(homonymInput);
        if (!isHomonym) {
            return true;
        }
        return false;
    }

    /**
     * Select an actor by:
     * Getting a list of actors
     * output them and asking for a selection which is the actors id
     * @return actorId int id for the actor selected
     */
    public int selectActor() {
        try {
            ResultSet actorSet = actorRepository.getAll();
            String actorIdString = actorView.getActorId(actorSet);
            return actorView.convertToOption(actorIdString, "actor", "actor_id");

        } catch (Exception e) {
            actorView.displayIncorrectInput();
            return 0;
        }
    }
}

