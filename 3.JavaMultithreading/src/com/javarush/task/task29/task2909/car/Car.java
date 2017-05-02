package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;


    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Car(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if(date.getTime() > summerStart.getTime() &&date.getTime() < summerEnd.getTime())
            return true;
        else
            return false;
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }
    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred(){
        return (driverAvailable&&fuel>0);
    }
    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
           throw new Exception();
        fuel += numberOfLiters;
    }
    public static Car create(int type, int numberOfPassengers){
        switch (type)
        {
            case(TRUCK):return new Truck(numberOfPassengers);
            case(SEDAN):return new Sedan(numberOfPassengers);
            case(CABRIOLET):return new Cabriolet(numberOfPassengers);
            default:return null;
        }
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        } else {
            return getWinterConsumption(length);
        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if(canPassengersBeTransferred())
            return numberOfPassengers;
        else
            return 0;

    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

}