package controllers;

import repository.SourceRepository;
import views.SourceView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SourceController {
    SourceView sourceView;
    SourceRepository sourceRepository;

    /**
     * Constructor to construct a source including a view and repo for that source
     */
    public SourceController() {
        sourceView = new SourceView();
        sourceRepository = new SourceRepository();
    }

    /**
     * Select an source by:
     * Getting a list of source
     * output them and asking for a selection which is the source id
     * @return sourceId int id for the source selected
     */
    public int selectSource() {
        try {
            ResultSet sourceSet = sourceRepository.getAll();
            return sourceView.getSourceId(sourceSet);
        } catch (SQLException e) {
            System.out.println(e);
        }
        // return 0 to return user to main menu
        return 0;
    }
}
