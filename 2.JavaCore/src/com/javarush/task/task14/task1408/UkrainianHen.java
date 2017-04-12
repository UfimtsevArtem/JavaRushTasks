package com.javarush.task.task14.task1408;

/**
 * Created by User on 25.02.2017.
 */
public class UkrainianHen extends Hen{
    String Sssss = "Ukraine";
    int N = 4;

    int getCountOfEggsPerMonth() {
        return this.N;
    }

    String getDescription() {
        return  super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }

}
