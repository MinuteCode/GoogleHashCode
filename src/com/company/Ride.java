package com.company;

/**
 * Created by bameur on 01/03/2018.
 */
public class Ride {
    private Intersection startIntersection;
    private Intersection finishIntersection;
    private int earliestStart;
    private int latestFinish;

    public Ride(Intersection startIntersection, Intersection finishIntersection, int earliestStart, int latestFinish) {
        this.startIntersection = startIntersection;
        this.finishIntersection = finishIntersection;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public Intersection getStartIntersection() {
        return startIntersection;
    }

    public void setStartIntersection(Intersection startIntersection) {
        this.startIntersection = startIntersection;
    }

    public Intersection getFinishIntersection() {
        return finishIntersection;
    }

    public void setFinishIntersection(Intersection finishIntersection) {
        this.finishIntersection = finishIntersection;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }
}
