package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BackgroundTestRepository extends BaseRepository {

    public void reset() throws SQLException {
        assert null != getConnection();
        PreparedStatement statement;

        statement = getConnection().prepareStatement("DELETE FROM organisation");
        statement.execute();

        statement = getConnection().prepareStatement("DELETE FROM actor");
        statement.execute();

        statement = getConnection().prepareStatement("DELETE FROM affiliation");
        statement.execute();

        statement.closeOnCompletion();
    }
}
