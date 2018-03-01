package com.company;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by bameur on 01/03/2018.
 */
public class Intersection {

    Pair<Integer, Integer> position;
ArrayList<Pair<Integer,Integer>> neighbors = new ArrayList<>();

    public Intersection(Pair<Integer, Integer> position, ArrayList<Pair<Integer, Integer>> neighbors) {
        this.position = position;



    }

    public Intersection(int posx, int posy, int R, int C) {
        this.position = new Pair<>(posx, posy);
        if(position.getKey() > 0)
            neighbors.add(new Pair<>(position.getKey() - 1, position.getValue()));
        if (position.getValue() > 0)
            neighbors.add(new Pair<>(position.getKey(), position.getValue() - 1));
        if (position.getKey() < R)
            neighbors.add(new Pair<>(position.getKey() + 1, position.getValue()));
        if (position.getValue() < C)
            neighbors.add(new Pair<>(position.getKey(), position.getValue() + 1));
    }

    @Override
    public String toString() {
        String print = "";
        print += "Intersection : " + position.getKey() + ";" + position.getValue();
        for (Pair<Integer,Integer> neighbor : neighbors) {
            print += "\n\tNeighbor : " + neighbor.getKey() + ";" + neighbor.getValue();
        }
        return print;
    }
}
