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
        ResultSet sourceSet;
        int sourceId = 0;
        try {
            sourceSet = sourceRepository.getAll();
            String source_id = sourceView.getSourceId(sourceSet);
            try {
                sourceId = sourceView.convertToOption(source_id, sourceSet, "source_id");
            } catch (Exception e) {
                sourceView.displayIncorrectInput();
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        // return 0 to return user to main menu
        return sourceId;
    }
}
