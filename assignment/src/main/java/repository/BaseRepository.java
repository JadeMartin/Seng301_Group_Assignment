package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


    public Connection getConnection() {
        return connection;
    }
}
