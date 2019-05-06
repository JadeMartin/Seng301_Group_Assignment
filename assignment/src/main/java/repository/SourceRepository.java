package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides an interface with the database
 */
public class SourceRepository extends BaseRepository{

    /**
     * Get all sources returns a result set of all sources in db
     * @throws SQLException
     */
    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("source");
    }
}
