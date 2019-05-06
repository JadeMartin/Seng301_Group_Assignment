package controllers;

import views.MenuView;

public class MenuController {

    private MenuView menuView;
    private OrganisationController organisationController;
    private ActorController actorController;
    private AffiliationController affiliationController;

    /**
     * Constructor
     */
    public MenuController() {
        this.menuView = new MenuView();
        this.organisationController = new OrganisationController();
        this.actorController = new ActorController();
        this.affiliationController = new AffiliationController();
    }

    /**
     * Loop through menu items and call relevant handler associated to it
     */
    public void startMenuLoop() {

        while(true) {
            int option;
            try {
                option = menuView.getMenuAction();
            } catch (Exception e) {
                menuView.displayIncorrectInput();
                continue;
            }

            switch(option) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    organisationController.insertOrganisation();
                    break;

                case 2:
                    actorController.insertActor();
                    break;

                case 3:
                    affiliationInsertHandler();
                    break;

                default:
                    menuView.displayOutOfBounds();
            }
        }
    }

    private void affiliationInsertHandler() {

        int actorId;
        Integer organisationId; //Integer instead of int for possible null value
        try {
            actorId = actorController.selectActor();
        } catch (Exception e) {
            menuView.displayIncorrectInput();
            return;
        }

        if (actorId != 0) {
            try {
                organisationId = organisationController.selectOrganisation();
            } catch (Exception e) {
                menuView.displayIncorrectInput();
                return;
            }

            if (organisationId == null || !organisationId.equals(0)) {
                affiliationController.insertAffiliationHandler(actorId, organisationId);
            }
        }
    }
}
