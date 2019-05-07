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
    public String getStartDate() {
        System.out.println("Enter Start Date with format DD/MM/YYYY or press enter to skip: ");
        return getInput();
    }

    /**
     * Provides a user input for a user to submit the end date of the affiliation
     * @return the user's level of trust that they submitted
     */
    public String getEndDate() {
        System.out.println("Enter End Date with format DD/MM/YYYY or press enter to skip: ");
        return getInput();
    }

    public Date convertToDate(String date) throws ParseException {
        return date == null ? null : new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }

    public void displaySuccessMessage() {
        super.displaySuccess("Affiliation successfully inserted");
    }

    public void displayErrorMessage() {
        super.displayError("Affiliation could not be inserted");
    }

    public void displayIncorrectDateOrder() { super.displayError("Start date is not before end date"); }
}
