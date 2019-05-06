package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscourseView extends BaseView {
    /**
     * provide user input to select discourse
     * @return source id
     */
    public int getDiscourseId(ResultSet resultSet) throws SQLException {
        System.out.println("Select a discourse by entering id: ");
        System.out.println("0: Back to menu");
        ArrayList<Integer> ids = new ArrayList<Integer>();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("discourse_id"));
            System.out.println(String.format("%d: %s", resultSet.getInt("discourse_id"), resultSet.getString("name")));
        }
        int id = getIntInput();
        if (ids.contains(id)) {
            return id;
        } else  if(id == 0) {
            return 0;
        }
        else {
            displayOutOfBounds();
            return 0;
        }

    }
}
