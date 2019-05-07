package repository;

import models.Affiliation;
import java.sql.*;

/**
 * Provides an interface with the database
 */
public class AffiliationRepository extends BaseRepository {

    public void insert(Affiliation affiliation) throws SQLException {
        if (null != getConnection()) {
            PreparedStatement statement = getConnection().prepareStatement("insert into affiliation (actor_id, organisation_id, role, start_date, end_date) values (?,?,?,?,?)");
            // use indexes of wildcard ("?") starting from 1
            statement.setInt(1, affiliation.getActorId());

            if (affiliation.getOrganisationId() == null) {
                statement.setNull(2, Types.INTEGER);
            } else {
                statement.setInt(2, affiliation.getOrganisationId());
            }

            statement.setString(3, affiliation.getRole());
            statement.setString(4, affiliation.getStartDateAsString());
            statement.setString(5, affiliation.getEndDateAsString());
            statement.executeUpdate();
            statement.closeOnCompletion();
        } else {
            System.out.println("Failed to insert");
        }
    }

    /**
     * Function to retrieve all affiliations connected to a given actor in the database using actor id
     */
    public ResultSet getAffiliations(int actor_id) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select * from affiliation where actor_id = ? ");
        statement.setInt(1, actor_id);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }
    }

