package repository;

import models.Argument;
import models.ArgumentLink;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Provides interface with argument table in the db
 */
public class ArgumentRepository extends BaseRepository {

    /**
    * Inserts the given argument into the database.db.
    **/
    public void insert(Argument argument) throws SQLException {
        //TODO check for valid input not null
        if (null != getConnection() && !argument.getRephrasing().equals("")) {
            PreparedStatement statement = getConnection().prepareStatement("insert into argument(discourse_id, actor_id, rephrasing, start, end) values (?,?,?,?,?)");
            // use indexes of wildcard ("?") starting from 1
            statement.setInt(1, argument.getDiscourseId());
            statement.setInt(2, argument.getActorId());
            statement.setString(3, argument.getRephrasing());
            statement.setInt(4, argument.getStart());
            statement.setInt(5, argument.getEnd());
            statement.executeUpdate();
            statement.closeOnCompletion();
        }
        else {
            System.out.println("Failed to insert");
        }
    }

    /**
     * function to insert a argument link between two arguments
     * @throws SQLException
     */
    public void insertLink(ArgumentLink argumentLink) throws SQLException {
        //TODO check for valid input not null
        if (null != getConnection()) {
            PreparedStatement statement = getConnection().prepareStatement("insert into argument_link(argument_one_id, argument_two_id, argument_link_type) values (?,?,?)");
            // use indexes of wildcard ("?") starting from 1
            statement.setInt(1, argumentLink.getArgumentOne());
            statement.setInt(2, argumentLink.getArgumentTwo());
            statement.setBoolean(3, argumentLink.getArgumentLinkType());
            statement.executeUpdate();
            statement.closeOnCompletion();
        }
        else {
            System.out.println("Failed to insert");
        }
    }

    /**
     * Check for duplicate entrys with same start and end indexs
     * @param discourseId
     * @param argumentStart
     * @param argumentEnd
     * @return boolean true for duplicate false for non duplicate entry
     */
    public boolean checkDuplicate(int discourseId, int argumentStart, int argumentEnd) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("select * from argument where discourse_id = ? and start = ? and end = ?");
        statement.setInt(1, discourseId);
        statement.setInt(2, argumentStart);
        statement.setInt(3, argumentEnd);
        ResultSet resultSet = statement.executeQuery();
        statement.closeOnCompletion();
        if (resultSet != null) {
            return false;
        }
        return true;
    }

    /**
     * Get all arguments in the database
     * @return
     * @throws SQLException
     */
    public ResultSet getAll() throws SQLException {
        return super.getAllByTableName("argument");
    }
}
