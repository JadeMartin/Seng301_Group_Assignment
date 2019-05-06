package views;

import models.Argument;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArgumentView extends BaseView {

    /**
     * Provides a user input for a user to submit their argument rephrasing
     * @return the user's arguments rephrasing that they submitted
     */
    public String getRephrasing() {
        System.out.println("Enter Argument Rephrasing: ");
        return getInput();
    }

    /**
     * Provides a user input for a user to submit the start of the argument as a index from the discourse
     * @return the user's  start of argument
     */
    public int getStart() {
        System.out.println("Enter the start index from the discourse: ");
        return getIntInput();
    }

    /**
     * Provides a user input for a user to submit the end of the argument as a index from the discourse
     * @return the user's  end of argument
     */
    public int getEnd() {
        System.out.println("Enter the end index from the discourse: ");
        return getIntInput();
    }

    public void displayDuplicateArgument() {
        super.displayError("This argument already exists");
    }

    public void displaySuccessMessage() {
        super.displaySuccess("The argument was inserted");
    }




    // Argument Link view

    /**
     * Display arguments so an argument can be selected via user input
     * @param arguments
     * @return int argument id for selected argument
     * @throws SQLException
     */
    public int displayArguments(ResultSet arguments) throws SQLException {
        System.out.println("Select an argument by entering id: ");
        System.out.println("0: Back to menu");
        while (arguments.next()) {
            System.out.println(String.format("%d: %s %d %d ", arguments.getInt("argument_id"), arguments.getString("rephrasing"), arguments.getInt("start"), arguments.getInt("end")));
        }
        return getIntInput();
    }


    /**
     * Get second argument to create an argument link
     * @param argumentOneId
     * @return int argument id for selected argument
     */
    public int getArgumentTwo(int argumentOneId) {
        // TODO check for duplicate entry ie argumentOneID
        System.out.println("Select another argument by entering another id: ");
        return getIntInput();
    }

    /**
     * provide user input to create an argument link
     * @return boolean of the inputed link type either true for for or false for against
     */
    public Boolean getArgumentLink() {
        //check for 0 to go back to menu
        System.out.println("Press 1 to create a for link type. \n" +
                "Press 2 to create an against link type\n" +
                "Press 0 to end program. \n");
        if (getIntInput() == 1) {
            return true;
        } else {
            return false;
        }
    }

}
