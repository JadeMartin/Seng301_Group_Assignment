package models;

/**
 * Contains message information to be displayed to user
 */
public class Message {

    /**
     * Message type used to prefix the displayed messages
     */
    public enum Type {
        ERROR,
        SUCCESS,
        CONFIRMATION
    }

    private String messageString;
    private Type type;

    /**
     * Constructor
     * @param messageString The additional string appended to the message
     * @param type The type of message
     */
    public Message(String messageString, Type type) {
        this.messageString = messageString;
        this.type = type;
    }

    /**
     * Displays the message string prefixed by the message type
     */
    public void displayMessage() {
        String prefix;

        switch(type) {
            case ERROR:
                prefix = "Error: ";
                break;
            case SUCCESS:
                prefix = "Success: ";
                break;
            case CONFIRMATION:
                prefix = "Please confirm: ";
                break;
            default:
                prefix = "";
        }

        System.out.println(prefix + messageString + "\n");
    }
}
