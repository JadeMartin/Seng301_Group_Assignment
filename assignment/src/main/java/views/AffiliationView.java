package views;

public class AffiliationView extends BaseView {

    /**
     * Provides a user input for a user to submit the role of the affiliation
     * @return the user's first name that they submitted
     */
    public String getRole() {
        System.out.println("Enter First Name: ");
        return getInput();
    }

    /**
     * Provides a user input for a user to submit the start date of the affiliation
     * @return the user's last name that they submitted
     */
    public String getStartDate() {
        System.out.println("Enter Start Date press enter to skip: ");
        return getInput();
    }

    /**
     * Provides a user input for a user to submit the end date of the affiliation
     * @return the user's level of trust that they submitted
     */
    public String getEndDate() {
        //TODO make enter actually skip
        System.out.println("Enter End Date press enter to skip: ");
        return getInput();
    }
}
