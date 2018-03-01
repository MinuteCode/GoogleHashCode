package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Car {
    int id;

    Pair<Integer, Integer> currentPosition;

    Ride ride;

    boolean isReachedStart = false;

    public Car(int id, int r, int c) {
        this.id = id;
        this.currentPosition = new Pair<>(r, c);
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
        if(ride != null) {
            this.isReachedStart = (this.currentPosition.equals(this.getRide().getStartIntersection().position));
        }
        else
            this.isReachedStart = false;
    }

    public void moveUp(int distance, int r){
        int newR = this.currentPosition.getKey() + distance;
        if(newR > r - 1)
            newR = r - 1;
        else if(newR < 0)
            newR = 0;

        Pair<Integer, Integer> newPosition = new Pair<>(newR, this.currentPosition.getValue());

        this.currentPosition = newPosition;
    }

    public void moveRight(int distance, int c){
        int newC = this.currentPosition.getValue() + distance;
        if(newC > c - 1)
            newC = c - 1;
        else if(newC < 0)
            newC = 0;

        Pair<Integer, Integer> newPosition = new Pair<>(this.currentPosition.getKey(), newC);

        this.currentPosition = newPosition;
    }

    public void moveNextPosition(int step, int r, int c){
        if(this.getRide() != null){

            if(step >= this.getRide().getEarliestStart()) {
                if (!this.isReachedStart) {
                    if (this.getRide().getStartIntersection().position.getKey() > this.currentPosition.getKey()) {
                        this.moveUp(1, r);
                    } else if (this.getRide().getStartIntersection().position.getKey() < this.currentPosition.getKey()) {
                        this.moveUp(-1, r);
                    } else if (this.getRide().getStartIntersection().position.getValue() > this.currentPosition.getValue()) {
                        this.moveRight(1, c);
                    } else if (this.getRide().getStartIntersection().position.getValue() < this.currentPosition.getValue()) {
                        this.moveRight(-1, c);
                    }

                    this.isReachedStart = (this.currentPosition.equals(this.getRide().getStartIntersection().position));
                } else {

                    if (this.getRide().getFinishIntersection().position.getKey() > this.currentPosition.getKey()) {
                        this.moveUp(1, r);
                    } else if (this.getRide().getFinishIntersection().position.getKey() < this.currentPosition.getKey()) {
                        this.moveUp(-1, r);
                    } else if (this.getRide().getFinishIntersection().position.getValue() > this.currentPosition.getValue()) {
                        this.moveRight(1, c);
                    } else if (this.getRide().getFinishIntersection().position.getValue() < this.currentPosition.getValue()) {
                        this.moveRight(-1, c);
                    }
                    if(this.currentPosition.equals(this.getRide().getFinishIntersection().position)){
                        this.setRide(null);
                    }
                }
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car " + this.id + " is at position (" + this.currentPosition.getKey() + ", " + this.currentPosition.getValue() + "). ReachedStart : " + this.isReachedStart;
    }
}
