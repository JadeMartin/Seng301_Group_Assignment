package repository;

import models.Affiliation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.format.DateTimeFormatter;

public class AffiliationRepository extends BaseRepository {

        public void insert(Affiliation affiliation) throws SQLException {
            if(null != getConnection()) {
                PreparedStatement statement = getConnection().prepareStatement("insert into affiliation (actor_id, organisation_id, role, start_date, end_date) values (?,?,?,?,?)");
                // use indexes of wildcard ("?") starting from 1
                statement.setInt(1, affiliation.getActorId());

                if (affiliation.getOrganisationId() == null) {
                    statement.setNull(2, Types.INTEGER);
                } else {
                    statement.setInt(2, affiliation.getOrganisationId());
                }

//                if (affiliation.getRole() == null) {
//                    statement.setNull(2, Types.V);
//                } else {
//                    statement.setInt(2, affiliation.getOrganisationId());
//                }
//
//                if (affiliation.getStartDateAsString() == null) {
//                    statement.setNull(2, Types.INTEGER);
//                } else {
//                    statement.setInt(2, affiliation.getOrganisationId());
//                }
//
//                if (affiliation.getEndDateAsString() == null) {
//                    statement.setNull(2, Types.INTEGER);
//                } else {
//                    statement.setInt(2, affiliation.getOrganisationId());
//                }


                System.out.println("did i get here?");
                statement.setString(3, affiliation.getRole());
                System.out.println("did i get here?");
                statement.setString(4, affiliation.getStartDateAsString());
                System.out.println("what about here?");
                statement.setString(5, affiliation.getEndDateAsString());
                System.out.println("here?");
                statement.executeUpdate();
                System.out.println("here2?");
                statement.closeOnCompletion();
            }
            else {
                System.out.println("Failed to insert");
            }
        }
    }

