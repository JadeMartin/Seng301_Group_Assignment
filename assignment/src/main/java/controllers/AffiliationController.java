package controllers;


import models.Affiliation;
import repository.AffiliationRepository;
import views.AffiliationView;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

/**
 * Controls organisation based functionality
 */
public class AffiliationController {
    AffiliationView affiliationView;
    AffiliationRepository affiliationRepository;

    /**
     * Constructor
     */
    public AffiliationController() {
        affiliationView = new AffiliationView();
        affiliationRepository = new AffiliationRepository();
    }

    public void insertAffiliationHandler(int actorId, Integer organisationId) {
        String affiliationRole = affiliationView.getRole();
        Date affiliationStartDate = null;
        Date affiliationEndDate = null;
        try {
            affiliationStartDate = affiliationView.getStartDate();
            affiliationEndDate = affiliationView.getEndDate();

        } catch (Exception e) {
            affiliationView.displayIncorrectInput();
            return;
        }
        Affiliation affiliation = new Affiliation(actorId, organisationId, affiliationRole, affiliationStartDate, affiliationEndDate);
        insertAffiliation(affiliation);
    }

    /**
     * Inserts an organisation by:
     * - Asking for the organisation name
     * - Inserting the organisation into the database.db
     * - If there is a duplicate entry: display error message and do not insert
     *   otherwise display success message
     */
    public void insertAffiliation(Affiliation affiliation) {

        if (!affiliation.getStartDate().before(affiliation.getEndDate())) {
            affiliationView.displayIncorrectDateOrder();
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

