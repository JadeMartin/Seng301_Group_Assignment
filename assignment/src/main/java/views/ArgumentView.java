package views;

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
}
