import controllers.MenuController;

/**
 * Main to begin command line program loop
 */
public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.startMenuLoop();
    }
}
