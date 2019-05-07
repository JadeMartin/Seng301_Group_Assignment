package controllers;


import models.Affiliation;
import repository.AffiliationRepository;
import views.AffiliationView;
import java.util.Date;
import java.sql.SQLException;

/**
 * Controls organisation based functionality
 */
public class AffiliationController {
    private AffiliationView affiliationView;
    private AffiliationRepository affiliationRepository;

    /**
     * Constructor
     */
    public AffiliationController() {
        affiliationView = new AffiliationView();
        affiliationRepository = new AffiliationRepository();
    }

    /**
     * Insert affiliation
     * Starts by asking for the role of the affiliation
     * then the start and end dates which is formatted and validated
     * finally insert the affiliation into the database
     */
    public void insertAffiliationHandler(int actorId, Integer organisationId) {
        String affiliationRole = affiliationView.getRole();
        Date startDate;
        Date endDate;

        try {
            String startDateString = affiliationView.getStartDate();
            startDate = affiliationView.convertToDate(startDateString);

            String endDateString = affiliationView.getEndDate();
            endDate = affiliationView.convertToDate(endDateString);

        } catch (Exception e) {
            affiliationView.displayIncorrectInput();
            return;
        }

        Affiliation affiliation = new Affiliation(actorId, organisationId, affiliationRole, startDate, endDate);
        insertAffiliation(affiliation);
    }

    /**
     * Function to validate the date strings
     */
    public void validateDates(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return;
        } else {
            if (!startDate.before(endDate)) {
                throw new RuntimeException();
            }
        }
    }

    /**
     * Inserts an organisation by:
     * - Asking for the organisation name
     * - Inserting the organisation into the database.db
     * - If there is a duplicate entry: display error message and do not insert
     *   otherwise display success message
     */
    public void insertAffiliation(Affiliation affiliation) {
        try {
            validateDates(affiliation.getStartDate(), affiliation.getEndDate());
        } catch (Exception e) {
            affiliationView.displayIncorrectInput();
            return;
        }

        // Try to insert organisation and display message based on success
        try {
            affiliationRepository.insert(affiliation);
            affiliationView.displaySuccessMessage();
        } catch (SQLException e) {
            affiliationView.displayErrorMessage();
        }
    }
}

