package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader file= new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        while(file.ready())
        {
            String[] strings = file.readLine().split(" ");
            String name = strings[0];
            double cash = Double.parseDouble(strings[1]);
            if (map.containsKey(name))
                map.put(name, (map.get(name) + cash));
            else
                map.put(name, cash);
        }
        file.close();
        double max = -1111111;
        for (Map.Entry<String,Double> z:map.entrySet()){
            if (z.getValue()>max) {
                max=z.getValue();
            }
        }
        for (Map.Entry<String,Double> z:map.entrySet()){
            if (z.getValue()==max) {
                System.out.print(z.getKey()+" ");
            }
        }
    }
}
