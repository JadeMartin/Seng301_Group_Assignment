package repository;

import java.sql.*;

public class BaseRepository {

    private static Connection connection = null;

    public BaseRepository() {

        if (connection == null) {
            // the path to the sqlite file, here it is at the root of current project
            String url = "jdbc:sqlite:database.sqlite";
            System.out.println("open connection to " + url);
            try {
                Connection connection = DriverManager.getConnection(url);
                this.connection = connection;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Get all items in a given table
     * takes a string input of a table name
     */
    public ResultSet getAllByTableName(String tableName) throws SQLException {
        assert null != connection;
        PreparedStatement statement = getConnection().prepareStatement("select * from " + tableName);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        return resultSet;
    }

    /**
     * Function to return the connection to the database
     */
    public Connection getConnection() {
        return connection;
    }
}
