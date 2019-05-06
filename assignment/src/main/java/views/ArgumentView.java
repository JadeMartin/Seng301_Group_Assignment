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

    public int displayArguments(ResultSet arguments) throws SQLException {
        while (arguments.next()) {
            System.out.println(String.format("%d: %s %d %d %d", arguments.getInt("argumentId"), arguments.getString("rephrasing"), arguments.getInt("start"), arguments.getInt("end")));
        }
        System.out.println("Select an argument by entering id: ");
        System.out.println("0: Back to menu");
        return getIntInput();
    }


    public int getArgumentTwo(int argumentOneId) {
        // TODO check for duplicate entry ie argumentOneID
        System.out.println("Select another argument by entering another id: ");
        System.out.println("0: Back to menu");
        return getIntInput();
    }

    public Boolean getArgumentLink() {
        //check for 0 to go back to menu
        System.out.println("Select an argument link 1 for true 2 for false: ");
        System.out.println("0: Back to menu");
        if (getIntInput() == 1) {
            return true;
        } else {
            return false;
        }
    }

}
