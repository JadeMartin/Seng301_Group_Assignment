package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Model class for the affiliation entity
 */
public class Affiliation {
    private int affiliationId;
    private int actorId;
    // Integer type to allow null values
    private Integer organisationId;
    private String role;
    private Date startDate;
    private Date endDate;
    private DateFormat dateFormat;

    /**
     * Constructor for an Affiliation
     * @param actorId
     * @param organisationId
     * @param role
     * @param startDate
     * @param endDate
     */
    public Affiliation(int actorId, Integer organisationId, String role, Date startDate, Date endDate) {
        this.actorId = actorId;
        this.organisationId = organisationId;
        this.role = role;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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

    public Integer getOrganisationId() {
        return organisationId;
    }

    public String getStartDateAsString() {
        return dateFormat.format(startDate);
    }

    public String getEndDateAsString() {
        return dateFormat.format((endDate));
    }
}