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
                    argumentInsertHandler();
                    break;

                case 5:
                    argumentController.insertArgumentLink();
                    break;

                default:
                    menuView.displayOutOfBounds();
            }
        }
    }

    /**
     * Function to handle the affiliation creation
     * Steps
     * Start by asking for actor
     * Then ask for organisation
     * then create affiliation
     */
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

    /**
     *  Function to handle the affiliation creation
     *  Steps
     *  Start by asking for valid actor id
     *  then ask for a source
     *  then ask for a discourse
     *  finally create an argument
     */
    private void argumentInsertHandler() {
        int actorId = 0;
        try {
            actorId = actorController.selectActor();
        } catch (Exception e) {
            menuView.displayIncorrectInput();
        }
        if (actorId != 0) {
            int sourceId = sourceController.selectSource();
            if (sourceId != 0) {
                int discourseId = discourseController.selectDiscourse(sourceId);
                if (discourseId != 0) {
                    argumentController.insertArgument(actorId, discourseId);
                }
            }
        }
    }
}
