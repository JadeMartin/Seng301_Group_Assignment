package views;

import models.Actor;
import models.Organisation;

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
        //TODO make enter actually skip
        System.out.println("Enter Level of trust press enter to skip: ");
        return getDoubleInput();
    }

    /**
     * provide user input to select actor
     * @param actorArrayList
     * @return actor  id
     */
    public int getActorId(ArrayList<Actor> actorArrayList) {
        System.out.println("Select an actor enter id: ");
        return getIntInput();

    }
}
