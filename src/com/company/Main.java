package com.company;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        int steps = 0;
        int R = 2;
        int C = 4;
        ArrayList<Ride> rides = null;
        ArrayList<Car> cars = new ArrayList<>();

        String line = "";
        int lineNumber = 1;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader("settings_file"));
            line = bfr.readLine();
            while(line != null) {
                System.out.println(line);
                if (lineNumber == 1) {
                    String[] splitString = line.split(" ");
                    R = Integer.valueOf(splitString[0]);
                    C = Integer.valueOf(splitString[1]);
                    int carsNumber = Integer.valueOf(splitString[2]);
                    int rideNumber = Integer.valueOf(splitString[3]);
                    steps = Integer.valueOf(splitString[5]);

                    rides = new ArrayList<>(rideNumber);

                    for (int i = 0; i < carsNumber; i++) {
                        cars.add(new Car(i,0,0));
                    }
                } else {
                    if (rides == null)  rides = new ArrayList<>();
                    String[] splitStringRide = line.split(" ");
                    Ride ride = new Ride(
                            new Intersection(
                                    Integer.valueOf(splitStringRide[0]),
                                    Integer.valueOf(splitStringRide[1]),
                                    R,
                                    C),
                            new Intersection(
                                    Integer.valueOf(splitStringRide[2]),
                                    Integer.valueOf(splitStringRide[3]),
                                    R,
                                    C),
                            Integer.valueOf(splitStringRide[4]),
                            Integer.valueOf(splitStringRide[5])
                    );
                    ride.setId(lineNumber - 1);
                    rides.add(ride);
                }
                line = bfr.readLine();
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        cars.get(0).setRide(rides.get(0));
        rides.sort(new Comparator<Ride>() {
            @Override
            public int compare(Ride o1, Ride o2) {
                return (o2.getEarliestStart() - o1.getEarliestStart());
            }
        });

        for (int i = 0; i < steps ; i++) {
            for (Car car : cars) {
                if(car.getRide() == null && !rides.isEmpty()) {
                    Ride ride = rides.get(0);
                    System.out.println("this vehicule " + car.id + " is assigned " + ride.getId());
                    car.setRide(ride);
                    rides.remove(ride);
                }
                else if(rides.isEmpty()){
                    System.out.println("All rides have been realised.");
                }

                car.moveNextPosition(i, R, C);
                System.out.println(car.toString());
            }

        }
    }
}
