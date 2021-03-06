package models;


/**
 * Model class for the Actor entity
 */
public class Actor{
    int actorId;
    String firstName;
    String lastName;
    Double levelOfTrust;

    /**
     * Constructor for an Actor Entity
     * @param firstName
     * @param lastName
     */
    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.levelOfTrust = 0.0;
    }

    //--- Setters ---
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLevelOfTrust(Double levelOfTrust) {
        this.levelOfTrust = levelOfTrust;
    }

    //--- Getters ---
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getLevelOfTrust() {
        return levelOfTrust;
    }

    public int getActorId() {
        return actorId;
    }

}
