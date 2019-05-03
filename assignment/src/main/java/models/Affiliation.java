package models;

import java.util.Date;

/**
 * Model class for the affiliation entity
 */
public class Affiliation {
    int affiliationId;
    int actorId;
    int organisationId;
    String role;
    String startDate;
    String endDate;

    /**
     * Constructor for an Affiliation
     * @param actorId
     * @param organisationId
     * @param role
     * @param startDate
     * @param endDate
     */
    public Affiliation(int actorId, int organisationId, String role, String startDate, String endDate) {
        this.actorId = actorId;
        this.organisationId = organisationId;
        this.role = role;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //--- Setters ---
    public void setRole(String role) {
        this.role = role;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    //--- Getters ---
    public String getRole() {
        return role;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getAffiliationId() {
        return affiliationId;
    }

    public int getActorId() {
        return actorId;
    }

    public int getOrganisationId() {
        return organisationId;
    }
}