package repository;

import models.Actor;
import models.Organisation;


import java.sql.*;
import java.util.ArrayList;

public class ActorRepository extends BaseRepository {

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

    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("actor");
    }

    public ResultSet getAllByFirstAndLast(String firstName, String lastName) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select * from actor where first_name = ? and last_name = ?");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }


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

    public double getLot(int actorId) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select level_of_trust from actor where actor_id = ? ");
        statement.setInt(1, actorId);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet.getDouble("level_of_trust");
    }



//    /**
//     * List all Actors in the database
//     * @param connection
//     * @return ArrayList of all actors added in the database
//     * @throws SQLException
//     */
//    public ArrayList<Actor> listAllActors(Connection connection) throws SQLException {
//        ArrayList<Actor> actorArrayList = new ArrayList<>();
//        if(true) {
//            System.out.println(connection);
//        } else {
//            System.out.println("Failed to get any organisations");
//        }
//        return actorArrayList;
//    }
    }

