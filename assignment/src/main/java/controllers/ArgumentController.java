package controllers;


import models.Argument;
import models.ArgumentLink;
import repository.ActorRepository;
import repository.ArgumentRepository;
import views.ArgumentView;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Controls Argument based functionality
 */
public class ArgumentController {
    private ArgumentView argumentView;
    private ArgumentRepository argumentRepository;
    private ActorRepository actorRepository;

    /**
     * Constructor for an argument also creates the argument view and repo
     */
    public ArgumentController() {
        argumentView = new ArgumentView();
        argumentRepository = new ArgumentRepository();
        actorRepository = new ActorRepository();
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
        try {
            argumentView.validateNotNullString(argumentRephrasing);
        } catch (Exception e) {
            argumentView.displayIncorrectInput();
            return;
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
            argumentView.validateIndexOrder(start, end);
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
        boolean boolLink;
        int argumentOne = 0;
        int argumentTwo = 0;
        try {
            ResultSet arguments = argumentRepository.getAll();
            try {
                String argumentOneId = argumentView.displayArguments(arguments);
                argumentOne = argumentView.convertTo(argumentOneId);
            } catch (Exception e) {
                argumentView.displayIncorrectInput();
            }
            if (argumentOne != 0) {
                try {
                    String argumentTwoId = argumentView.getArgumentTwo();
                    argumentTwo = argumentView.convertTo(argumentTwoId);
                } catch (Exception e) {
                    argumentView.displayIncorrectInput();
                }
                if (argumentTwo != 0) {
                    try {
                        argumentView.validateNotSameArgument(argumentOne, argumentTwo);
                    } catch (Exception e) {
                        argumentView.displaySameArgument();
                        return;
                    }

                    String link = argumentView.getArgumentLink();
                    try {
                        boolLink = argumentView.convertToBool(link);
                        ArgumentLink argumentLink = new ArgumentLink(argumentOne, argumentTwo, boolLink);
                        Double confidence = argumentRepository.getArgumentConfidence(boolLink, argumentOne);
                        argumentRepository.insertLink(argumentLink);
                        argumentRepository.updateArgument(argumentOne, confidence);
                        int actorId = argumentRepository.getUser(argumentOne);
                        double lot = actorRepository.getLot(actorId);
                        actorRepository.updateLevelOfTrust(actorId, lot + confidence);
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