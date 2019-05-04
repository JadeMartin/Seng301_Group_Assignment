package controllers;

import models.Organisation;
import repository.ActorRepository;
import views.ActorView;
import models.Actor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        String actorLastName = actorView.getLastName();
        Double actorLevelOfTrust = actorView.getLevelOfTrust();
        Actor actor = new Actor(actorFirstName, actorLastName, actorLevelOfTrust);

        // Try to insert actor and display message based on success
        try {
            if (!checkIfHomonym(actor)) {
                actorRepository.insert(actor);
                actorView.displaySuccessMessage();
            } else {
                actorView.displayNotHomonymMessage();
            }
        } catch (SQLException e) {
            System.out.println(e);
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

