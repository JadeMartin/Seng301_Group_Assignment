package repository;

import models.Organisation;

import java.sql.*;

/**
 * Provides an interface with the database.db
 */
public class OrganisationRepository extends BaseRepository{
    /**
     * Inserts the given organisation into the database.db.
     * TODO: Right now this method just emulates the duplicate entry check. Change once we got db set up
     * @param
     * @throws
     */

    public void insert(Connection connection, Organisation organisation) throws SQLException {
        if(null != connection && null != organisation.getOrganisationName()) {
            PreparedStatement statement = connection.prepareStatement("insert into organisation(name) values (?)");
            // use indexes of wildcard ("?") starting from 1
            statement.setString(1, organisation.getOrganisationName());
            System.out.println("rows added: " + statement.executeUpdate());
            statement.closeOnCompletion();
        }
        else {
            System.out.println("Failed to insert");
        }
    }
}
