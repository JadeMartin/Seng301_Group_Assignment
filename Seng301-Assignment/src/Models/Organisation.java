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
    public void setOrganisationName(String name) {
        this.name = name;
    }

    //--- Getters ---
    public String getOrganisationName() {
        return name;
    }

    public int getOrganisationIdId() {
        return organisationId;
    }

}