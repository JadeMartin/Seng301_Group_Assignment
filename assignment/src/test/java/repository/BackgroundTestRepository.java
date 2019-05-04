package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BackgroundTestRepository extends BaseRepository {

    public void reset() throws SQLException {
        assert null != getConnection();
        PreparedStatement statement = getConnection().prepareStatement("DELETE FROM organisation");
        statement.execute();
        statement.closeOnCompletion();
    }
}
