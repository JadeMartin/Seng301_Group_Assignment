package controllers;


import com.sun.org.apache.xpath.internal.operations.Bool;
import models.Argument;
import models.ArgumentLink;
import repository.ArgumentRepository;
import views.ArgumentView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Controls Argument based functionality
 */
public class ArgumentController {
    ArgumentView argumentView;
    ArgumentRepository argumentRepository;

    /**
     * Constructor
     */
    public ArgumentController() {
        argumentView = new ArgumentView();
        argumentRepository = new ArgumentRepository();
    }

    /**
     * Inserts an Argument by:
     * - Asking for the argument rephrasing
     * - Inserting the argument into the database.db
     * - If there is a duplicate entry: display error message and do not insert
     * otherwise display success message
     */
    public void insertArgument(int actorId, int discourseId) {
        String argumentRephrasing = argumentView.getRephrasing();
        int argumentStart = argumentView.getStart();
        int argumentEnd = argumentView.getEnd();
        Argument argument = new Argument(discourseId, actorId, argumentRephrasing, argumentStart, argumentEnd);

        // Try to insert argument and display message based on success
        try {
            if(argumentRepository.checkDuplicate(discourseId, argumentStart, argumentEnd)){
                argumentView.displayDuplicateArgument();
            } else {
                argumentRepository.insert(argument);
                argumentView.displaySuccessMessage();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertArgumentLink() {
        try {
            ResultSet arguments = argumentRepository.getAll();
            int argumentOneId = argumentView.displayArguments(arguments);
            int argumentTwoId = argumentView.getArgumentTwo(argumentOneId);
            Boolean link = argumentView.getArgumentLink();
            ArgumentLink argumentLink = new ArgumentLink(argumentOneId, argumentTwoId, link);
            argumentRepository.insertLink(argumentLink);
            argumentView.displaySuccessMessage();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}