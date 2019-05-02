package repository;

import models.Organisation;

import java.sql.SQLException;

/**
 * Provides an interface with the database
 */
public class OrganisationRepository {
    /**
     * Inserts the given organisation into the database.
     * TODO: Right now this method just emulates the duplicate entry check. Change once we got db set up
     * @param organisation The organisation that is going to be inserted
     * @throws SQLException
     */
    public void insert(Organisation organisation) throws SQLException {
        if (organisation.getOrganisationName().equals("organisation")) {
            throw new SQLException();
        }
    }
}
