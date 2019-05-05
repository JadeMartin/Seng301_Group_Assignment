package controllers;


import views.MenuView;

public class MenuController {

    private MenuView menuView;
    private OrganisationController organisationController;
    private ActorController actorController;
    private AffiliationController affiliationController;
    private SourceController sourceController;
    private DiscourseController discourseController;
    private ArgumentController argumentController;

    /**
     * Constructor
     */
    public MenuController() {
        this.menuView = new MenuView();
        this.organisationController = new OrganisationController();
        this.actorController = new ActorController();
        this.affiliationController = new AffiliationController();
        this.sourceController = new SourceController();
        this.discourseController = new DiscourseController();
        this.argumentController = new ArgumentController();
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

                case 4:
                    argumentInsertHandler(1);
                    break;

                case 5:
                    argumentInsertHandler(2);
                    break;

                default:
                    menuView.displayOutOfBounds();
            }
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

    private void argumentInsertHandler(int option) {
        int actorId = actorController.selectActor();
        if (actorId != 0) {
            int sourceId = sourceController.selectSource();
            if (sourceId != 0) {
                int discourseId = discourseController.selectDiscourse(sourceId);
                if (sourceId != 0) {
                    //Links ??
                    if (option == 1) {
                        argumentController.insertArgument(actorId, discourseId);
                    } else if (option == 2) {
                        argumentController.insertArgumentLink();
                    }
                }
            }
        }
    }
}
