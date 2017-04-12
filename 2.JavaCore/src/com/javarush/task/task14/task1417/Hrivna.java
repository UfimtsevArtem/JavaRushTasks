package com.javarush.task.task14.task1417;

/**
 * Created by User on 27.02.2017.
 */
public class Hrivna extends Money {
    public String getCurrencyName(){
        return "HRN";
    }

    public Hrivna(double amount) {
        super(amount);
    }
}
