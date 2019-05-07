package models;

public class Organisation {
    private int organisationId;
    private String name;

    /**
     * Constructor for an Organisation Entity
     */
    public Organisation(String name) {
        this.name = name;
    }

    //--- Getters ---
    public String getOrganisationName() {
        return name;
    }
    public int getOrganisationId() {
        return organisationId;
    }


}