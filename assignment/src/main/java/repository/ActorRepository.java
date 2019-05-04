package repository;

import models.Actor;
import models.Organisation;


import java.sql.*;
import java.util.ArrayList;

public class ActorRepository extends BaseRepository {

    public void insert(Actor actor) throws SQLException {
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

