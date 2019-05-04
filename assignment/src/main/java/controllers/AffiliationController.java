package controllers;


import models.Affiliation;
import repository.AffiliationRepository;
import views.AffiliationView;

import java.sql.Connection;
import java.sql.Date;
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

    /**
     * Inserts an organisation by:
     * - Asking for the organisation name
     * - Inserting the organisation into the database.db
     * - If there is a duplicate entry: display error message and do not insert
     *   otherwise display success message
     */
    public void insertAffiliation(int actorId, int organisationId) {


//        String affiliationRole = affiliationView.getRole();
//        String affiliationStartDate = affiliationView.getStartDate();
//        String affiliationEndDate = affiliationView.getEndDate();
//        Affiliation affiliation = new Affiliation(actorId, organisationId, affiliationRole, affiliationStartDate, affiliationEndDate);
//
//        // Try to insert organisation and display message based on success
//        try {
//            Connection connection = affiliationRepository.databaseSetup();
//            affiliationRepository.insert(connection, affiliation);
//            // organisationView.displaySuccessMessage();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
    }
}

