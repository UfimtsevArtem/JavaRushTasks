package com.javarush.task.task15.task1522;

/**
 * Created by User on 28.02.2017.
 */
public class Moon implements Planet {
    private static Moon instance = null;

    private Moon() {}

    public static Moon getInstance() {
        if (instance == null)
            instance = new Moon();
        return instance;
    }
}