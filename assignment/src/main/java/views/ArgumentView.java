package views;

import models.Argument;

import javax.swing.text.html.HTMLDocument;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArgumentView extends BaseView {
    ArrayList<Integer> ids = new ArrayList<Integer>();

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
    public String getStart() {
        System.out.println("Enter the start index from the discourse: ");
        return getInput();
    }

    /**
     * Provides a user input for a user to submit the end of the argument as a index from the discourse
     * @return the user's  end of argument
     */
    public String getEnd() {
        System.out.println("Enter the end index from the discourse: ");
        return getInput();
    }

    public void validateIndexOrder(int start, int end) {
        if (start >= end) {
            throw new RuntimeException();
        }
    }

    public void displayDuplicateArgument() {
        super.displayError("This argument already exists");
    }

    public void displaySuccessMessage() {
        super.displaySuccess("The argument was inserted");
    }

    /**
     * Display arguments so an argument can be selected via user input
     * @param arguments
     * @return int argument id for selected argument
     * @throws SQLException
     */
    public String displayArguments(ResultSet arguments) throws SQLException {
        System.out.println("Select an argument by entering an id: ");
        System.out.println("0) Back to menu");
        while (arguments.next()) {
            ids.add(arguments.getInt("argument_id"));
            System.out.println(String.format("%d) Rephrasing: %s\n   Start: %d End: %d ", arguments.getInt("argument_id"), arguments.getString("rephrasing"), arguments.getInt("start"), arguments.getInt("end")));
        }
        return getInput();
    }


        /**
         * Get second argument to create an argument link
         * @return int argument id for selected argument
         */
    public String getArgumentTwo() {
        System.out.println("Select another argument by entering another id: ");
        return getInput();
    }


    /**
     * provide user input to create an argument link
     * @return boolean of the inputed link type either true for for or false for against
     */
    public String getArgumentLink() {
        //check for 0 to go back to menu
        System.out.println("Create an argument link \n" +
                "Press 1 to create a backed link type. \n" +
                "Press 2 to create an contradicted link type\n" +
                "Press 0 back to menu. \n");
        return getInput();
    }

    public int convertTo(String argumentStart) {
        int argumentIndex = Integer.parseInt(argumentStart);
        if(argumentIndex < 0) {
            throw new RuntimeException();
        }
        return argumentIndex;
    }

    public boolean convertToBool(String link) {
        int linkInt = Integer.parseInt(link);
        if (linkInt == 1) {
            return true;
        } else if (linkInt == 2) {
            return false;
        } else {
            throw new RuntimeException();
        }
    }

    public void displaySameArgument() {
        super.displayError("Can not select the same argument twice to create a link");
    }

    public void displayIncorrectEnd() {
        super.displayError("Start needs to be before end index");
    }
}
