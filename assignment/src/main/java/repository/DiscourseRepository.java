package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides an interface with the database
 */
public class DiscourseRepository extends BaseRepository{

    /**
     * Get all discourses by source Id
     * @param sourceId
     * @return
     * @throws SQLException
     */
    public ResultSet getAllBySource(int sourceId) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select * from discourse where sourceId = ?");
        statement.setInt(1, sourceId);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }

    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("discourse");
    }

}
