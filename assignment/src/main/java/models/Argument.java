package models;

/**
 * Model class for the argument entity
 */
public class Argument {
    int argumentId;
    int discourseId;
    int actorId;
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
    public Argument(int discourseId, int actorId, String rephrasing, int start, int end) {
        this.discourseId = discourseId;
        this.actorId = actorId;
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

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    //--- Getters ---
    public int getActorId() {
        return actorId;
    }

    public int getDiscourseId() {
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