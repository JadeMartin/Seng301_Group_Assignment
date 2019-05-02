package views;

import models.Message;

import java.util.Scanner;

/**
 * Base view that is inherited by other views
 * Views include any scanner calls or output messages
 */
public class BaseView {
    private Scanner scanner;

    /**
     * Constructor
     */
    public BaseView() {
        scanner = new Scanner(System.in);
    }

    /**
     * Gets user input from scanner
     * @return most recent user input
     */
    public String getInput() {
        return scanner.nextLine();
    }

    /**
     * Displays a message with the type set to error
     * @param messageString The string to add to the message
     */
    public void displayError(String messageString) {
        Message message = new Message(messageString, Message.Type.ERROR);
        message.displayMessage();
    }

    /**
     * Displays a message with the type set to confirmation
     * @param messageString The string to add to the message
     */
    public void displayConfirmation(String messageString) {
        Message message = new Message(messageString, Message.Type.CONFIRMATION);
        message.displayMessage();
    }

    /**
     * Displays a message with the type set to success
     * @param messageString The string to add to the message
     */
    public void displaySuccess(String messageString) {
        Message message = new Message(messageString, Message.Type.SUCCESS);
        message.displayMessage();
    }

}
