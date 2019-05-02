package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {

    public Connection databaseSetup() {

        // the path to the sqlite file, here it is at the root of current project
        String url = "jdbc:sqlite:database.db";
        System.out.println("open connection to " + url);
        try(Connection connection = DriverManager.getConnection(url)) {
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
