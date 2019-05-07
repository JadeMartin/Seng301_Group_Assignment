package controllers;

import repository.ActorRepository;
import views.ActorView;
import models.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorController {
    ActorView actorView;
    ActorRepository actorRepository;

    /**
     * Constructor
     */
    public ActorController() {
        actorView = new ActorView();
        actorRepository = new ActorRepository();
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

    public void insertIfNotHomonym(Actor actor) throws SQLException{
        if (!askIfHomonym(actor)) {
            actorRepository.insert(actor);
            actorView.displaySuccessMessage();
        } else {
            actorView.displayNotHomonymMessage();
        }
    }

    private boolean askIfHomonym(Actor actor) throws SQLException, RuntimeException {
        //TODO: Display affiliations
        boolean isHomonym = false;
        ResultSet actorSet = actorRepository.getAllByFirstAndLast(actor.getFirstName(), actor.getLastName());

        while(actorSet.next()) {
            // Get and validate whether the actor is the same
            String homonymInput = actorView.askIfHomonym(actorSet.getString("first_name"), actorSet.getString("last_name"));
            isHomonym = actorView.convertHomonymInput(homonymInput);

            if (isHomonym) {
                return true;
            }
        }

        return isHomonym;
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

