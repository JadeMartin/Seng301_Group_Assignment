package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SourceView extends BaseView {
    /**
     * provide user input to select source
     * @return source id
     */
    public String getSourceId(ResultSet resultSet) throws SQLException {
        System.out.println("Select a source by entering id: ");
        System.out.println("0) Back to menu");
        while (resultSet.next()) {
            System.out.println(String.format("%d) Name: %s", resultSet.getInt("source_id"), resultSet.getString("name")));
        }
        return getInput();
    }

}
