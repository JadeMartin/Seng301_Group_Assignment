package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganisationTestRepository extends BaseRepository {
    public ResultSet getByName(String name) throws SQLException {
        assert null != getConnection();
        PreparedStatement statement = getConnection().prepareStatement("select * from organisation where name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }

}
