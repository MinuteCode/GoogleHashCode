package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Car {
    int id;

    Pair<Integer, Integer> currentPosition;

    Ride ride;

    public Car(int id, int r, int c) {
        this.id = id;
        this.currentPosition = new Pair<>(r, c);
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
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

    @Override
    public String toString() {
        return "Car " + this.id + " is at position (" + this.currentPosition.getKey() + ", " + this.currentPosition.getValue() + ")";
    }
}
