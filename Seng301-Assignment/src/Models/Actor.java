package Models;


/**
 * Model class for the Actor entity
 */
public class Actor{
    int actorId;
    String firstName;
    String lastName;
    double levelOfTrust;

    /**
     * Constructor for an Actor Entity
     * @param firstName
     * @param lastName
     * @param levelOfTrust
     */
    public Actor(String firstName, String lastName, double levelOfTrust) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.levelOfTrust = levelOfTrust;
    }

    //--- Setters ---

    /**
     * Set the first name of an Actor
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the last name of an Actor
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the level of trust of an Actor
     * @param levelOfTrust
     */
    public void setLevelOfTrust(double levelOfTrust) {
        this.firstName = firstName;
    }

    //--- Getters ---

    /**
     * function to return the first name of an Actor
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * function to return the last name of an Actor
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * function to return the level of trust of an Actor
     * @return
     */
    public double getLevelOfTrust() {
        return levelOfTrust;
    }

    /**
     * function to return the actor id of an Actor
     * @return
     */
    public int getActorId() {
        return actorId;
    }

}
