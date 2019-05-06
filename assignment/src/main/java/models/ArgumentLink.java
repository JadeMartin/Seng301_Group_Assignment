package models;

public class ArgumentLink {
    int argumentOne;
    int argumentTwo;
    boolean argumentLinkType;
    /**
     * Constructor for an Argument link Entity
     */
    public ArgumentLink(int argumentOne, int argumentTwo, boolean argumentLinkType) {
        this.argumentOne = argumentOne;
        this.argumentTwo = argumentTwo;
        this.argumentLinkType = argumentLinkType;
    }

    //--- Setters ---
    public void setArgumentOne(int argumentOne) {
        this.argumentOne = argumentOne;
    }

    public void setArgumentTwoArgumentTwo(int argumentTwo) {
        this.argumentTwo = argumentTwo;
    }

    public void setArgumentLinkType(boolean argumentLinkType) {
        this.argumentLinkType = argumentLinkType;
    }


    //--- Getters ---
    public int getArgumentOne() {
        return argumentOne;
    }

    public int getArgumentTwo() {
        return argumentTwo;
    }

    public boolean getArgumentLinkType() {
        return argumentLinkType;
    }
}
