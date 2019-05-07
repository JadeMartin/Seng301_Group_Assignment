package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscourseView extends BaseView {

    /**
     * provide user input to select discourse
     * @return source id
     */
    public String getDiscourseId(ResultSet resultSet) throws SQLException {
        System.out.println("Select a discourse by entering id: ");
        System.out.println("0: Back to menu");
        while (resultSet.next()) {
            System.out.println(String.format("%d: %s", resultSet.getInt("discourse_id"), resultSet.getString("name")));
        }
        return getInput();
    }
}
