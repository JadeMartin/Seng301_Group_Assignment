package repository;

import models.Actor;
import models.Organisation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActorRepository extends BaseRepository {

        public void insert(Connection connection, Actor actor) throws SQLException {
            if(null != connection && null != actor.getFirstName() && null != actor.getLastName()) {
                PreparedStatement statement = connection.prepareStatement("insert into actor (first_name, last_name, level_of_trust) values (?,?,?)");
                // use indexes of wildcard ("?") starting from 1
                statement.setString(1, actor.getFirstName());
                statement.setString(2, actor.getLastName());
                statement.setDouble(3, actor.getLevelOfTrust());
                System.out.println("rows added: " + statement.executeUpdate());
                statement.closeOnCompletion();
            }
            else {
                System.out.println("Failed to insert");
            }
        }

    /**
     * List all Actors in the database
     * @param connection
     * @return ArrayList of all actors added in the database
     * @throws SQLException
     */
    public ArrayList<Actor> listAllActors(Connection connection) throws SQLException {
        ArrayList<Actor> actorArrayList = new ArrayList<>();
        if(true) {
            System.out.println(connection);
        } else {
            System.out.println("Failed to get any organisations");
        }
        return actorArrayList;
    }
    }

