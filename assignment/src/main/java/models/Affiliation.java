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
    Date startDate;
    Date endDate;

    /**
     * Constructor for an Affiliation
     * @param role
     * @param startDate
     * @param endDate
     */
    public Affiliation(String role, Date startDate, Date endDate) {
        this.role = role;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //--- Setters ---
    public void setRole(String role) {
        this.role = role;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //--- Getters ---
    public String getRole() {
        return role;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
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