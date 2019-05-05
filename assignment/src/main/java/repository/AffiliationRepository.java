package repository;

import models.Affiliation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class AffiliationRepository extends BaseRepository {

        public void insert(Affiliation affiliation) throws SQLException {
            if(null != getConnection() && null != affiliation.getRole()) {
                PreparedStatement statement = getConnection().prepareStatement("insert into affiliation (actor_id, organisation_id, role, start_date, end_date) values (?,?,?,?,?)");
                // use indexes of wildcard ("?") starting from 1
                statement.setInt(1, affiliation.getActorId());
                statement.setInt(2, affiliation.getOrganisationId());
                statement.setString(3, affiliation.getRole());

                statement.setString(4, affiliation.getStartDateAsString());
                statement.setString(5, affiliation.getEndDateAsString());
                statement.executeUpdate();
                statement.closeOnCompletion();
            }
            else {
                System.out.println("Failed to insert");
            }
        }
    }

