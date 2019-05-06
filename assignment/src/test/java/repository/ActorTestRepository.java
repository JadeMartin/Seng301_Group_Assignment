package repository;

import models.Actor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorTestRepository extends BaseRepository{
    public ResultSet getAll() throws SQLException {
        assert null != getConnection();
        PreparedStatement statement = getConnection().prepareStatement("select * from actor");
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }
}
