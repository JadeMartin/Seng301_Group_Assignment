package repository;

import models.Affiliation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AffiliationRepository extends BaseRepository {

        public void insert(Connection connection, Affiliation affiliation) throws SQLException {
            if(null != connection && null != affiliation.getRole()) {
                PreparedStatement statement = connection.prepareStatement("insert into affiliation (actor_id, organisation_id, role, start_date, end_date) values (?,?,?,?,?)");
                // use indexes of wildcard ("?") starting from 1
                statement.setInt(1, affiliation.getActorId());
                statement.setInt(2, affiliation.getOrganisationId());
                statement.setString(3, affiliation.getRole());
                statement.setString(3, affiliation.getStartDate());
                statement.setString(3, affiliation.getEndDate());
                System.out.println("rows added: " + statement.executeUpdate());
                statement.closeOnCompletion();
            }
            else {
                System.out.println("Failed to insert");
            }
        }
    }

