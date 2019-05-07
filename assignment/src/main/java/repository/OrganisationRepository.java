package repository;

import models.Organisation;

import java.sql.*;

/**
 * Provides an interface with the database
 */
public class OrganisationRepository extends BaseRepository{
    /**
     * Inserts the given organisation into the database.db.
     * Takes in an organisation
     */
    public void insert(Organisation organisation) throws SQLException {

        if (null != getConnection() && !organisation.getOrganisationName().equals("")) {
            PreparedStatement statement = getConnection().prepareStatement("insert into organisation(name) values (?)");
            // use indexes of wildcard ("?") starting from 1
            statement.setString(1, organisation.getOrganisationName());
            statement.executeUpdate();
            statement.closeOnCompletion();
        }
        else {
            System.out.println("Failed to insert");
        }
    }

    /**
     * Function to get all organisations
     */
    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("Organisation");
    }
}
