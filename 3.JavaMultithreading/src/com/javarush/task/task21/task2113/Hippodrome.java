package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 17.03.2017.
 */
public class Hippodrome {
    private static List<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    public void run(){
        for (int i = 0; i <100 ; i++) {
            move();
            print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                System.out.println("Ошибка sleep");
            }
        }
    }
    public void print(){
        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println("");
        }
    }
    public void move(){
        for (int i = 0; i <horses.size() ; i++) {
            horses.get(i).move();
        }
    }
    public Horse getWinner(){
        Horse winner = null;
        double maxDistance = 0;
        for (Horse h:horses) {
            if(h.getDistance()>maxDistance)
                maxDistance = h.getDistance();
        }
        for (Horse h:horses) {
            if(h.getDistance()==maxDistance)
                winner = h;
        }
        return winner;
    }
    public void printWinner(){
        String name = getWinner().getName();
        System.out.println("Winner is " + name + "!");
    }
    public static void main(String[] args) {
    game = new Hippodrome(horses);
        Horse horse1 = new Horse("Sleven",3,0);
        Horse horse2 = new Horse("Lucky",3,0);
        Horse horse3 = new Horse("Gomer",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();
    }
}
