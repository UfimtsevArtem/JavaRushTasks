package com.javarush.task.task26.task2602;

import java.util.*;

/* 
Был бы ум - будет и успех
*/
public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));
        List<Soldier> soldiers1 = new ArrayList<>(soldiers);
        Collections.sort(soldiers1);

        for (Soldier soldier : soldiers1) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier> {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public int compareTo(Soldier soldier)
        {
            return soldier.height - this.height;
        }
    }
}
