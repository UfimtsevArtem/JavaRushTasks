package com.javarush.task.task14.task1408;

/**
 * Created by User on 26.02.2017.
 */
abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    String getDescription() {
        String text = "Я - курица.";
        return text;
    }
}
