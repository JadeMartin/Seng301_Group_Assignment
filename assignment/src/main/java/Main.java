import controllers.OrganisationController;
import controllers.ActorController;
import views.MenuView;

public class Main {


    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        ActorController actorController = new ActorController();
        OrganisationController organisationController = new OrganisationController();
        //TODO check for validation of ints
        int option = menuView.getMenuAction();
        while(option != 0) { // Loop around with a menu
            if (option == 1){
                organisationController.insertOrganisation();
            } else if (option == 2){
                actorController.insertActor();
            } else if (option == 3) {
                //select actor / affiliation
                //affiliationController.insertAffiliation(affiliation)
                System.out.println("Todo select actor and organisation and insert Affiliation ");
            }
            option = menuView.getMenuAction();
        }
    }
}
