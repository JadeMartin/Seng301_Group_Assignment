package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliationTestRepository extends BaseRepository {
    public ResultSet getAll() throws SQLException {
        assert null != getConnection();
        PreparedStatement statement = getConnection().prepareStatement("select * from affiliation");
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }
}
