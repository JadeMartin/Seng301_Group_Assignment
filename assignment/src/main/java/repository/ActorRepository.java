package repository;

import models.Actor;
import java.sql.*;


/**
 * Provides an interface with the database
 */
public class ActorRepository extends BaseRepository {

    /**
     * Insert an actor into the database
     */
    public void insert(Actor actor) throws SQLException {
        if (!actor.getFirstName().equals("") && !actor.getLastName().equals("")) {
            PreparedStatement statement = getConnection().prepareStatement("insert into actor (first_name, last_name, level_of_trust) values (?,?,?)");
            // use indexes of wildcard ("?") starting from 1
            statement.setString(1, actor.getFirstName());
            statement.setString(2, actor.getLastName());

            if (actor.getLevelOfTrust() == null) {
                statement.setNull(3, Types.DOUBLE);
            } else {
                statement.setDouble(3, actor.getLevelOfTrust());
            }

            statement.executeUpdate();
            statement.closeOnCompletion();
        } else {
            System.out.println("Could not insert");
        }
    }

    /**
     * Retrieve all actors stored in database
     */
    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("actor");
    }

    /**
     * Retrieve all actors from a given first and last name
     */
    public ResultSet getAllByFirstAndLast(String firstName, String lastName) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select * from actor where first_name = ? and last_name = ?");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }


    /**
     * Update an actors level of trust calculated from all of their arguments backings and contradictions
     */
    public void updateLevelOfTrust(int actorId, Double level_of_trust) throws SQLException {
        if (null != getConnection()) {
            PreparedStatement updateStatement = getConnection().prepareStatement("update actor "
                    + "set level_of_trust = ? "
                    + "Where actor_id = ?; ");
            updateStatement.setDouble(1, level_of_trust);
            updateStatement.setInt(2, actorId);
            updateStatement.executeUpdate();
            updateStatement.closeOnCompletion();
        } else {
            System.out.println("Failed to insert");
        }
    }

    /**
     * Retrieved from the database Lot = level of trust of an actor of a given actor id
     * Lot = Level of trust
     */
    public double getLot(int actorId) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select level_of_trust from actor where actor_id = ? ");
        statement.setInt(1, actorId);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet.getDouble("level_of_trust");
    }
}