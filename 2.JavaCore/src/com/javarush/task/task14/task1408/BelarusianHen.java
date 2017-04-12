package com.javarush.task.task14.task1408;

/**
 * Created by User on 25.02.2017.
 */
public class BelarusianHen extends Hen {
    static String Sssss = "Belarus";
    static int N = 3;

    int getCountOfEggsPerMonth() {
        System.out.println(N);
        return this.N;
    }

    String getDescription() {
        return  super.getDescription()+" Моя страна - "+Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }

}
