package com.javarush.task.task29.task2909.car;

/**
 * Created by User on 20.04.2017.
 */
public class Cabriolet extends Car {
    public Cabriolet(int numberOfPassengers) {
        super(numberOfPassengers);
    }
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
