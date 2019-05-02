package views;

/**
 * Contains anything that the user sees or interacts with
 * These include all print statements and scanner inputs
 */
public class OrganisationView extends BaseView {

    /**
     * Provides a user input for a user to submit their name
     * @return the user's name that they submitted
     */
    public String getName() {
        System.out.println("Enter Organisation Name: ");
        return getInput();
    }

    /**
     * Displays the message relating to if the organisation already exists
     */
    public void displayDuplicateEntryMessage() {
        super.displayError("This organisation already exists");
    }

    /**
     * Displays a confirmation message
     */
    public void displaySuccessMessage() {
        super.displaySuccess("The organisation was inserted");
    }
}