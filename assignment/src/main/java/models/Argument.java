package models;

/**
 * Model class for the argument entity
 */
public class Argument {
    int argumentId;
    int discourseId;
    String rephrasing;
    int start;
    int end;

    /**
     * Constructor for an Argument Entity
     * @param discourseId
     * @param rephrasing
     * @param start
     * @param end
     */
    public Argument(int discourseId, String rephrasing, int start, int end) {
        this.discourseId = discourseId;
        this.rephrasing = rephrasing;
        this.start = start;
        this.end = end;
    }

    //--- Setters ---
    public void setRephrasing(String rephrasing) {
        this.rephrasing = rephrasing;
    }

    public void setDiscourseId(int discourseId) {
        this.discourseId = discourseId;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    //--- Getters ---
    public int getdiscourseId() {
        return discourseId;
    }

    public String getRephrasing() {
        return rephrasing;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public int getArgumentId() {
        return argumentId;
    }

}