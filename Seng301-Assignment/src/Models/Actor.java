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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setLevelOfTrust(double levelOfTrust) {
        this.firstName = firstName;
    }

    //--- Getters ---
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getLevelOfTrust() {
        return levelOfTrust;
    }

    public int getActorId() {
        return actorId;
    }

}
