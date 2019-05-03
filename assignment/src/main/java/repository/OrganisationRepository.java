package repository;

import models.Organisation;

import java.sql.*;
import java.util.ArrayList;

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

    public void insert(Organisation organisation) throws SQLException {

        if(null != getConnection() && null != organisation.getOrganisationName()) {
            PreparedStatement statement = getConnection().prepareStatement("insert into organisation(name) values (?)");
            // use indexes of wildcard ("?") starting from 1
            statement.setString(1, organisation.getOrganisationName());
            statement.closeOnCompletion();
        }
        else {
            System.out.println("Failed to insert");
        }
    }

    /**
     * List all organisations in the database
     * @param connection
     * @return ArrayList of all organisations added in the database
     * @throws SQLException
     */
    public ArrayList<Organisation> listAllOrganisations(Connection connection) throws SQLException {
        ArrayList<Organisation> organisationArrayList = new ArrayList<>();
        if(true) {
            System.out.println(connection);
        } else {
            System.out.println("Failed to get any organisations");
        }
        return organisationArrayList;
    }
}
