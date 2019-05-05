package models;

public class ArgumentLink {
    Argument argumentOne;
    Argument argumentTwo;
    boolean argumentLinkType;
    /**
     * Constructor for an Argument link Entity
     */
    public ArgumentLink(Argument argumentOne, Argument argumentTwo, boolean argumentLinkType) {
        this.argumentOne = argumentOne;
        this.argumentTwo = argumentTwo;
        this.argumentLinkType = argumentLinkType;
    }

    //--- Setters ---
    public void setArgumentOne(Argument argumentOne) {
        this.argumentOne = argumentOne;
    }

    public void setArgumentTwoArgumentTwo(Argument argumentTwo) {
        this.argumentTwo = argumentTwo;
    }

    public void setArgumentLinkType(boolean argumentLinkType) {
        this.argumentLinkType = argumentLinkType;
    }


    //--- Getters ---
    public Argument getArgumentOne() {
        return argumentOne;
    }

    public Argument getArgumentTwo() {
        return argumentTwo;
    }

    public boolean getArgumentLinkType() {
        return argumentLinkType;
    }
}
