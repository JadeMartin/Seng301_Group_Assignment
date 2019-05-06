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
     * Constructor for an argument also creates the argument view and repo
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
        if (argumentRephrasing == null) {
            argumentView.displayIncorrectInput();
        }

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

    /**
     * Function to insert an argument link by:
     * - Asking for the first argument id
     * - Asking for the second argument id
     * - Asking for the link type
     * - inserting into the db
     * - display message depending on success or failure
     */
    public void insertArgumentLink() {
        boolean boolLink = false;
        int link = 0;
        int argumentTwoId = 0;
        try {
            ResultSet arguments = argumentRepository.getAll();
            int argumentOneId = argumentView.displayArguments(arguments);
            if (argumentOneId != 0) {
                argumentTwoId = argumentView.getArgumentTwo(argumentOneId);
                if (argumentTwoId != 0) {
                    link = argumentView.getArgumentLink();
                    if (link == 1) {
                        boolLink = true;
                    } else if (link == 2) {
                        boolLink = false;
                    }
                }
            }
            if (link != 0) {
                ArgumentLink argumentLink = new ArgumentLink(argumentOneId, argumentTwoId, boolLink);
                argumentRepository.insertLink(argumentLink);
                argumentView.displaySuccessMessage();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}