package com.javarush.task.task12.task1219;

/* 
Fly, Run, Swim для классов Human, Duck, Penguin, Airplane
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }


    public class Human implements Run, Swim {
        public void swim(){}
        public void run(){}
    }

    public class Duck implements Run, Swim, Fly {
        public void swim(){}
        public void run(){}
        public void fly(){}

    }

    public class Penguin implements Run, Swim{
        public void swim(){}
        public void run(){}

    }

    public class Airplane implements Fly, Run{
        public void fly(){}
        public void run(){}

    }
}
