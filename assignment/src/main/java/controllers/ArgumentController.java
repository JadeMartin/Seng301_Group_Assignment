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

        String argumentStart = argumentView.getStart();
        int start;
        try {
            start = argumentView.convertTo(argumentStart);
            if (start == -1){
                return;
            }
        } catch (Exception e) {
            argumentView.displayIncorrectInput();
            return;
        }

        String argumentEnd = argumentView.getEnd();
        int end;
        try {
            end = argumentView.convertTo(argumentEnd);
            if (end <= start) {
                //TODO change message to end needs to be after start
                argumentView.displayIncorrectInput();
                return;
            }
        } catch (Exception e) {
            argumentView.displayIncorrectInput();
            return;
        }

        Argument argument = new Argument(discourseId, actorId, argumentRephrasing, start, end);

        // Try to insert argument and display message based on success
        try {
            if(argumentRepository.checkDuplicate(discourseId, start, end)){
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
        int argumentOne = 0;
        int argumentTwo = 0;
        //TODO check arguement one and two are not the same

        try {
            ResultSet arguments = argumentRepository.getAll();
            String argumentOneId = argumentView.displayArguments(arguments);
            String argumentTwoId = argumentView.getArgumentTwo();

            try {
                argumentOne = argumentView.convertTo(argumentOneId);
            } catch (Exception e) {
                argumentView.displayIncorrectInput();
            }
            if (argumentOne != 0) {
                try {
                    argumentTwo = argumentView.convertTo(argumentTwoId);
                } catch (Exception e) {
                    argumentView.displayIncorrectInput();
                }
                if (argumentTwo != 0) {
                    String link = argumentView.getArgumentLink();
                    try {
                        boolLink = argumentView.convertToBool(link);
                        ArgumentLink argumentLink = new ArgumentLink(argumentOne, argumentTwo, boolLink);
                        argumentRepository.insertLink(argumentLink);
                        argumentView.displaySuccessMessage();
                    } catch (Exception e) {
                            argumentView.displayIncorrectInput();
                        }
                    }
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}