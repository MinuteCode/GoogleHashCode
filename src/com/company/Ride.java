package com.company;

/**
 * Created by bameur on 01/03/2018.
 */
public class Ride implements Comparable {
    private Intersection startIntersection;
    private Intersection finishIntersection;
    private int earliestStart;
    private int latestFinish;
    private int id;

    public Ride(Intersection startIntersection, Intersection finishIntersection, int earliestStart, int latestFinish) {
        this.startIntersection = startIntersection;
        this.finishIntersection = finishIntersection;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(Object o) {
        Ride r = (Ride)o;
        if (this.earliestStart < r.earliestStart)
            return -1;
        else if (this.earliestStart == r.earliestStart)
            return 0;
        else
            return 1;
    }
}
