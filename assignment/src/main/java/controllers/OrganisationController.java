package controllers;


import models.Organisation;
import repository.OrganisationRepository;
import views.OrganisationView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
            organisationRepository.insert(organisation);
            organisationView.displaySuccessMessage();
        } catch (SQLException e) {
            System.out.println(e);
            organisationView.displayDuplicateEntryMessage();
        }
    }

    /**
     * Select an organisation by:
     * Getting a list of organisations
     * outputing them and asking for a selection which is the organisations id
     * @return organisationId int id for the organisation selected
     */
    public int selectOrganisation() {
//        Connection connection = organisationRepository.databaseSetup();
//        int organisationId;
//        try {
//            ArrayList<Organisation> organisationArrayList = organisationRepository.listAllOrganisations(connection);
//            organisationId = organisationView.getOrganisationId(organisationArrayList);
//            return organisationId;
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
        return 0;
    }
}
