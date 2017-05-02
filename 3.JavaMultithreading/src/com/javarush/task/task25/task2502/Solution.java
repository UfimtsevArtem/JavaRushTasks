package com.javarush.task.task25.task2502;

import java.security.spec.ECField;
import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<>();
            String[] names = loadWheelNamesFromDB();
            if (names.length != 4) {
                throw new Exception();
            }
            for (String name : names) {
                if (Wheel.valueOf(name) == null) {
                    throw new Exception();
                } else
                    wheels.add(Wheel.valueOf(name));

            }
        }

        protected String[] loadWheelNamesFromDB() throws Exception {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }


        public static void main(String[] args) {

        }
    }
}
