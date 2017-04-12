package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.javarush.task.task15.task1522.Planet.EARTH;
import static com.javarush.task.task15.task1522.Planet.MOON;
import static com.javarush.task.task15.task1522.Planet.SUN;

/* 
Закрепляем Singleton pattern
*/
public class Solution {
    public static Planet thePlanet;
    //add static block here - добавьте статический блок тут
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if(s.equals(Planet.SUN)){
            thePlanet = Sun.getInstance();
        }else if(s.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();
        }else if(s.equals(Planet.MOON)){
            thePlanet = Moon.getInstance();
        }else{
            thePlanet = null;
        }
    }
}
