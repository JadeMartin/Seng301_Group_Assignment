package views;

/**
 * Contains anything that the user sees or interacts with
 * These include all print statements and scanner inputs
 */
public class MenuView extends BaseView {

    /**
     * Provides a user input for a user to submit their menu input
     * @return the user's menu option that they submitted
     */
    public int getMenuAction() {

        setScanner();
        System.out.println("Please Enter an Action: \n" +
                "Press 1 to create a new Organisation. \n" +
                //Maybe add viewing all organisations
                "Press 2 to create a new Actor. \n" +
                //Maybe add viewing all Actors
                "Press 3 to create a new Affiliation between an Actor and an Organisation. \n" +
                //Maybe add viewing all Affiliations
                "Press 4 to create a new Argument. \n" +
                "Press 5 to create a new Argument Link between two different arguments \n" +
                "Press 0 to end program. \n");
        return getIntInput();
    }
}