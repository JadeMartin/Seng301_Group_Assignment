package repository;

import models.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    }

