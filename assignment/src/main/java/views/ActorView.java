package views;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ActorView extends BaseView {

    /**
     * Provides a user input for a user to submit their first name
     * @return the user's first name that they submitted
     */
    public String getFirstName() {
        System.out.println("Enter First Name: ");
        return getInput();
    }

    /**
     * Provides a user input for a user to submit their last name
     * @return the user's last name that they submitted
     */
    public String getLastName() {
        System.out.println("Enter Last Name: ");
        return getInput();
    }

    /**
     * Function to convert an homonym input returning true for 1 or false for 2
     */
    public boolean convertHomonymInput(String homonymInput) throws RuntimeException {
        if (homonymInput.equals("1")) {
            return true;
        } else if (homonymInput.equals("2")) {
            return false;
        } else {
            throw new RuntimeException();
        }
    }

    /**
     * provide user input to select actor
     * @return actor  id
     */
    public String getActorId(ResultSet resultSet) throws SQLException {
        System.out.println("Select an actor by entering id: ");
        System.out.println("0) Back to menu");

        while (resultSet.next()) {
            System.out.println(String.format("%d) First name: %s\n   Last name: %s\n   Level of trust: %.2f", resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getDouble("level_of_trust")));
        }

        return getInput();
    }

    /**
     * Function to ask whether the actor is already existing
     * first out puts actor and their affiliation
     * then asks user whether it is the same actor or a new one with the same name
     */
    public void askIfHomonym(String firstName, String lastName, ResultSet resultSet) throws SQLException {
        System.out.println("Actor: " + firstName +" "+ lastName + " is currently affiliated with:");
        int count = 1;
        while (resultSet.next()) {
            System.out.println(String.format("%d) Role: %s\n   Start Date: %s\n   End Date: %s\n   Organisation Id: %d", count, resultSet.getString("role"), resultSet.getString("start_date"), resultSet.getString("end_date"), resultSet.getInt("organisation_id")));
            count++;
        }
        if (count == 1){
            System.out.println("No Organisations");
        }
    }

    public String getHomonym(String firstName, String lastName) {
        super.displayConfirmation("Would you like to insert the actor?");
        System.out.println(firstName +" "+ lastName);
        System.out.println("1: Yes\n" +
                "2: No");
        return getInput();

    }

    public void displaySuccessMessage() {
        super.displaySuccess("The actor was inserted");
    }

    public void displayNotHomonymMessage() {
        super.displaySuccess("Duplicate insertion prevented");
    }
}
