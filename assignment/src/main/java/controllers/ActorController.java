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
        String actorFirstName = actorView.getFirstName();
        if (actorFirstName == null) {
            actorView.displayIncorrectInput();
            return;
        }

        String actorLastName = actorView.getLastName();
        if (actorLastName == null) {
            actorView.displayIncorrectInput();
            return;
        }

        Double actorLevelOfTrust = actorView.getLevelOfTrust();
        Actor actor = new Actor(actorFirstName, actorLastName, actorLevelOfTrust);

        // Try to insert actor and display message based on success
        try {
            insertIfNotHomonym(actor);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertIfNotHomonym(Actor actor) throws SQLException{
        if (!checkIfHomonym(actor)) {
            actorRepository.insert(actor);
            actorView.displaySuccessMessage();
        } else {
            actorView.displayNotHomonymMessage();
        }
    }

    private boolean checkIfHomonym(Actor actor) throws SQLException {
        //TODO: Display affiliations
        boolean isHomonym = false;
        ResultSet actorSet = actorRepository.getAllByFirstAndLast(actor.getFirstName(), actor.getLastName());

        while(actorSet.next()) {
            if (actorView.askIfHomonym(actorSet.getString("first_name"), actorSet.getString("last_name"))) {
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
            return actorView.getActorId(actorSet);

        } catch (SQLException e) {
            System.out.println(e);
        }
        // return 0 to return user to main menu
        return 0;
    }
}

