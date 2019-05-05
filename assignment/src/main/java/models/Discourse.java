package models;

/**
 * Model class for the discourse entity
 */
public class Discourse {
    int discourseId;
    int sourceId;
    String name;

    /**
     * Constructor for an Discourse Entity
     * @param sourceId
     * @param name
     */
    public Discourse(int sourceId, String name) {
        this.sourceId = sourceId;
        this.name = name;
    }

    //--- Setters ---
    public void setName(String name) {
        this.name = name;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    //--- Getters ---
    public int getDiscourseId() {
        return discourseId;
    }

    public String getName() {
        return name;
    }

    public int getSourceId() {
        return sourceId;
    }

}