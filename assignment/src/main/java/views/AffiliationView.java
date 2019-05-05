package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AffiliationView extends BaseView {

    /**
     * Provides a user input for a user to submit the role of the affiliation
     * @return the user's first name that they submitted
     */
    public String getRole() {
        System.out.println("Enter Role Name or press enter to skip: ");
        return getInput();
    }

    /**
     * Provides a user input for a user to submit the start date of the affiliation
     * @return the user's last name that they submitted
     */
    public Date getStartDate() throws ParseException {
        System.out.println("Enter Start Date or press enter to skip: ");
        String input = getInput();
        return input == null ? null : new SimpleDateFormat("dd/MM/yyyy").parse(input);
    }

    /**
     * Provides a user input for a user to submit the end date of the affiliation
     * @return the user's level of trust that they submitted
     */
    public Date getEndDate() throws ParseException {
        System.out.println("Enter End Date or press enter to skip: ");
        String input = getInput();
        return input == null ? null : new SimpleDateFormat("dd/MM/yyyy").parse(input);
    }

    public void displaySuccessMessage() {
        super.displaySuccess("Affiliation successfully inserted");
    }

    public void displayErrorMessage() {
        super.displayError("Affiliation could not be inserted");
    }
}
