package com.javarush.task.task14.task1417;

/**
 * Created by User on 27.02.2017.
 */
public class Ruble extends Money {
    public String getCurrencyName(){
        return "RUB";
    }

    public Ruble(double amount) {
        super(amount);
    }
}
