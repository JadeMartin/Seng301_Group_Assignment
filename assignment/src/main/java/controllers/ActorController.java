package controllers;

import models.Organisation;
import repository.ActorRepository;
import views.ActorView;
import models.Actor;

import java.sql.Connection;
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

        // Try to insert organisation and display message based on success
        try {
            Connection connection = actorRepository.databaseSetup();
            actorRepository.insert(connection, actor);
            // organisationView.displaySuccessMessage();
        } catch (SQLException e) {
            System.out.println(e);
            //actorView.displayDuplicateEntryMessage();
        }
    }

    /**
     * Select an actor by:
     * Getting a list of actors
     * output them and asking for a selection which is the actors id
     * @return actorId int id for the actor selected
     */
    public int selectActor() {
        Connection connection = actorRepository.databaseSetup();
        int actorId;
        try {
            ArrayList<Actor> actorArrayList = actorRepository.listAllActors(connection);
            actorId = actorView.getActorId(actorArrayList);
            return actorId;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
}

