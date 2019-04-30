package Models;

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

    /**
     * Set the role of an Affiliation
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Set the start date of an Affiliation
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Set the end date of an Affiliation
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //--- Getters ---

    /**
     * function to return the role of an Affiliation
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * function to return the role of an Affiliation
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * function to return the End date of an Affiliation
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * function to return the Affiliation Id of an Affiliation
     * @return
     */
    public int getAffiliationId() {
        return affiliationId;
    }

    /**
     * function to return the Actor Id of an Affiliation of an Affiliation
     * @return
     */
    public int getActorId() {
        return actorId;
    }

    /**
     * function to return the Organisation Id of an Affiliation
     * @return
     */
    public int getOrganisationId() {
        return organisationId;
    }
}