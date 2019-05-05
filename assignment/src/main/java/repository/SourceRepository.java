package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides an interface with the database
 */
public class SourceRepository extends BaseRepository{

    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("source");
    }
}
