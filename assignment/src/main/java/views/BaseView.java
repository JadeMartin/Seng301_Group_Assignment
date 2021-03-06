package views;

import models.Message;
import repository.BaseRepository;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Base view that is inherited by other views
 * Views include any scanner calls or output messages
 */
public class BaseView {
    private Scanner scanner;
    private BaseRepository baseRepository;

    /**
     * Constructor
     */
    public BaseView() {
        setScanner();
        baseRepository = new BaseRepository();
    }

    public void setScanToString(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        setScanner();
    }

    /**
     * Sets scanner to a new scanner
     */
    public void setScanner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Gets user input from scanner
     * @return most recent user input
     */
    public String getInput() {
        String input = scanner.nextLine();
        return input.equals("") ? null : input;
    }

    /**
     * get user input when expecting int from scanner
     * @return most recent int input
     */
    public int getIntInput() {
        return Integer.parseInt(scanner.nextLine());
    }


    /**
     * Function to validate a string to make sure it is not null
     * @param string
     * @throws RuntimeException
     */
    public void validateNotNullString(String string) throws RuntimeException {
        if (string.isEmpty()) {
            throw new RuntimeException();
        }
    }

    /**
     * Function to check that the input is in the correct bounds of the given range
     */
    public int convertToOption(String inputString, String tableName, String colName) throws SQLException {
        ResultSet resultSet = baseRepository.getAllByTableName(tableName);

        int input = Integer.parseInt(inputString);

        if (input == 0) {
            return input;
        }
        while (resultSet.next()) {
            if (resultSet.getInt(colName) == input) {
                return input;
            }
        }
        throw new RuntimeException();
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

    /**
     * Displays the message relating to if the input is an incorrect format
     */
    public void displayIncorrectInput() {
        displayError("Input is incorrect");
    }

    /**
     * Displays the message relating to if the input is out of bounds
     */
    public void displayOutOfBounds() {
        displayError("Input is out of bounds");
    }

}
