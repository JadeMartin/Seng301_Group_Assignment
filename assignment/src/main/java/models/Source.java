package models;

/**
 * Model class for the discourse entity
 */
public class Source {
    int sourceId;
    String name;

    /**
     * Constructor for an Discourse Entity
     * @param name
     */
    public Source(String name) {
        this.name = name;
    }

    //--- Setters ---
    public void setName(String name) {
        this.name = name;
    }


    //--- Getters ---
    public String getName() {
        return name;
    }

    public int getSourceId() {
        return sourceId;
    }

}