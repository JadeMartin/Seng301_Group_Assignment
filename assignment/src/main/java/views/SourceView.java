package views;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SourceView extends BaseView {
    /**
     * provide user input to select source
     * @return source id
     */
    public int getSourceId(ResultSet resultSet) throws SQLException {
        System.out.println("Select a source by entering id: ");
        System.out.println("0: Back to menu");
        ArrayList<Integer> ids = new ArrayList<Integer>();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("source_id"));
            System.out.println(String.format("%d: %s", resultSet.getInt("source_id"), resultSet.getString("name")));
        }
        int id = getIntInput();
        if (ids.contains(id)) {
            return id;
        } else {
            displayOutOfBounds();
            return 0;
        }

    }
}
