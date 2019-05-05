package views;

import models.Actor;
import models.Organisation;

import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
     * Provides a user input for a user to submit their level of trust
     * @return the user's level of trust that they submitted
     */
    public Double getLevelOfTrust() {
        System.out.println("Enter Level of trust press enter to skip: ");
        return getDoubleInput();
    }

    /**
     * provide user input to select actor
     * @param actorArrayList
     * @return actor  id
     */
    public int getActorId(ResultSet resultSet) throws SQLException {
        System.out.println("Select an actor by entering id: ");
        System.out.println("0: Back to menu");
        while (resultSet.next()) {
            System.out.println(String.format("%d: %s %s", resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name")));
        }
        return getIntInput();
    }

    public boolean askIfHomonym(String firstName, String lastName) {
        super.displayConfirmation("Is this you?");
        System.out.println(firstName + lastName);
        System.out.println("1: Yes\n" +
                           "2: No");
        return getIntInput() == 1;
    }

    public void displaySuccessMessage() {
        super.displaySuccess("The actor was inserted");
    }

    public void displayNotHomonymMessage() {
        super.displaySuccess("Duplicate insertion prevented");
    }
}
