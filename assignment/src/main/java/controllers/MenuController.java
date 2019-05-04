package controllers;

import views.MenuView;

public class MenuController {

    private MenuView menuView;
    private OrganisationController organisationController;
    private ActorController actorController;
    private AffiliationController affiliationController;

    public MenuController() {
        this.menuView = new MenuView();
        this.organisationController = new OrganisationController();
        this.actorController = new ActorController();
        this.affiliationController = new AffiliationController();
    }

    public void start() {

        //TODO check for validation of ints
        int option = menuView.getMenuAction();

        while(option != 0) { // Loop around with a menu
            switch(option) {
                case 1:
                    organisationController.insertOrganisation();
                    break;
                case 2:
                    actorController.insertActor();
                    break;
                case 3:
                    affiliationInsertHandler();
            }
            option = menuView.getMenuAction();
        }
    }

    private void affiliationInsertHandler() {

        int actorId = actorController.selectActor();
        if (actorId != 0) {
            int organisationId = organisationController.selectOrganisation();
            if (organisationId != 0) {
                affiliationController.insertAffiliation(actorId, organisationId);
            }
        }
    }
}
