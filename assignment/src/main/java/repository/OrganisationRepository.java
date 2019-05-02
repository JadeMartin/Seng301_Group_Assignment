package repository;

import models.Organisation;

import java.sql.*;

/**
 * Provides an interface with the database
 */
public class OrganisationRepository {
    /**
     * Inserts the given organisation into the database.
     * TODO: Right now this method just emulates the duplicate entry check. Change once we got db set up
     * @param
     * @throws
     */
    public Connection databaseSetup() {

        // the path to the sqlite file, here it is at the root of current project
        String url = "jdbc:sqlite:database.sqlite";
        System.out.println("open connection to " + url);
        try(Connection connection = DriverManager.getConnection(url)) {
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insert(Connection connection, Organisation organisation) throws SQLException {
        assert null != connection && null != organisation.getOrganisationName();
        PreparedStatement statement = connection.prepareStatement("insert into organisation(name) values (?)");
        // use indexes of wildcard ("?") starting from 1
        statement.setString(1, organisation.getOrganisationName());
        System.out.println("rows added: " + statement.executeUpdate());
        statement.closeOnCompletion();
    }
}
