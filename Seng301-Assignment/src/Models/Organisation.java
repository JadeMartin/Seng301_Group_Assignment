package Models;

public class Organisation {
    int organisationId;
    String name;

    /**
     * Constructor for an Organisation Entity
     * @param name
     */
    public Organisation(String name) {
        this.name = name;
    }

    //--- Setters ---
    /**
     * Set the name of an Organisation
     * @param name
     */
    public void setOrganisationName(String name) {
        this.name = name;
    }

    //--- Getters ---
    /**
     * function to return the name of an Organisation
     * @return
     */
    public String getOrganisationName() {
        return name;
    }

    /**
     * function to return the Organisation id of an Organisation
     * @return
     */
    public int getOrganisationIdId() {
        return organisationId;
    }

}