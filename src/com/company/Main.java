package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int R = 2;
        int C = 4;

        Car car = new Car(1, 0, 0);
        System.out.println(car.toString());
        car.moveRight(1, C);
        System.out.println(car.toString());
        car.moveUp(1, R);
        car.moveUp(1, R);
        car.moveUp(1, R);
        car.moveUp(1, R);
        car.moveUp(1, R);
        car.moveUp(1, R);
        System.out.println(car.toString());

        ArrayList<Intersection> intersections = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                intersections.add(new Intersection(i, j, R, C));
            }
        }

    }
}
