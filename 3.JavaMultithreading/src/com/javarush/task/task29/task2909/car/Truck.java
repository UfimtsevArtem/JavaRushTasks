package com.javarush.task.task29.task2909.car;

/**
 * Created by User on 20.04.2017.
 */
public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(numberOfPassengers);
    }
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
