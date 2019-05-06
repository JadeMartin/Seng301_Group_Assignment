package repository;

import models.Organisation;

import java.sql.*;
import java.util.ArrayList;

/**
 * Provides an interface with the database
 */
public class OrganisationRepository extends BaseRepository{
    /**
     * Inserts the given organisation into the database.db.
     * @param
     * @throws
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

    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("Organisation");
    }
}
