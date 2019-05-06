package controllers;

import repository.DiscourseRepository;
import views.DiscourseView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscourseController {
    DiscourseView discourseView;
    DiscourseRepository discourseRepository;

    /**
     * Constructor for a discourse also initializing a view and repo for that discourse
     */
    public DiscourseController() {
        discourseView = new DiscourseView();
        discourseRepository = new DiscourseRepository();
    }

    /**
     * Select a discourse by:
     * Getting a list of discourse from selected source
     * output them and asking for a selection which is the discourse id
     * @return discourse int id for the actor selected
     */
    public int selectDiscourse(int sourceId) {
        try {
            ResultSet discourseSet = discourseRepository.getAllBySource(sourceId);
            return discourseView.getDiscourseId(discourseSet);
        } catch (SQLException e) {
            System.out.println(e);
        }
        // return 0 to return user to main menu
        return 0;
    }
}
