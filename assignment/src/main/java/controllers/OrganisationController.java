package controllers;


import models.Organisation;
import repository.OrganisationRepository;
import views.OrganisationView;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Controls organisation based functionality
 */
public class OrganisationController {
    OrganisationView organisationView;
    OrganisationRepository organisationRepository;

    /**
     * Constructor
     */
    public OrganisationController() {
        organisationView = new OrganisationView();
        organisationRepository = new OrganisationRepository();
    }

    /**
     * Inserts an organisation by:
     * - Asking for the organisation name
     * - Inserting the organisation into the database.db
     * - If there is a duplicate entry: display error message and do not insert
     *   otherwise display success message
     */
    public void insertOrganisation() {
        String organisationName = organisationView.getName();
        Organisation organisation = new Organisation(organisationName);

        // Try to insert organisation and display message based on success
        try {
            Connection connection = organisationRepository.databaseSetup();
            organisationRepository.insert(connection, organisation);
           // organisationView.displaySuccessMessage();
        } catch (SQLException e) {
            organisationView.displayDuplicateEntryMessage();
        }
    }
}
