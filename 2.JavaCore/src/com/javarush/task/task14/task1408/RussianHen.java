package com.javarush.task.task14.task1408;

/**
 * Created by User on 25.02.2017.
 */
public class RussianHen extends Hen {
    String Sssss = "Russia";
    int N = 3;

    int getCountOfEggsPerMonth() {
        return this.N;
    }

    String getDescription() {
        return  super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";     }
}