import controllers.OrganisationController;
import controllers.ActorController;
import controllers.AffiliationController;
import views.MenuView;

public class Main {


    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        ActorController actorController = new ActorController();
        OrganisationController organisationController = new OrganisationController();
        AffiliationController affiliationController = new AffiliationController();
        //TODO check for validation of ints
        int option = menuView.getMenuAction();
        int actorId;
        int organisationId;
        while(option != 0) { // Loop around with a menu
            if (option == 1){
                organisationController.insertOrganisation();
            } else if (option == 2){
                actorController.insertActor();
            } else if (option == 3) {
                //select actor / organisation
                actorId = actorController.selectActor();
                if (actorId != 0) {
                    organisationId = organisationController.selectOrganisation();
                    if (organisationId != 0) {
                        affiliationController.insertAffiliation(actorId, organisationId);
                    }
                }
            }
            option = menuView.getMenuAction();
        }
    }
}
