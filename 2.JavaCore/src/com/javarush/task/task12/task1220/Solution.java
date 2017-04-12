package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы Run, Swim
*/

public class Solution {
    public static void main(String[] args) {

    }

    interface Run{
        void run();
    }
    interface Swim{
        void swim();
    }
    abstract class Human implements Run, Swim{

    }
}
