package views;

import models.Actor;
import models.Organisation;
import org.omg.SendingContext.RunTime;

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
        System.out.println("0: Back to menu");

        while (resultSet.next()) {
            System.out.println(String.format("%d: %s %s", resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name")));
        }

        return getInput();
    }

    public String askIfHomonym(String firstName, String lastName) {
        super.displayConfirmation("Would you like to insert homonym actor?");
        System.out.println(firstName + lastName);
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
