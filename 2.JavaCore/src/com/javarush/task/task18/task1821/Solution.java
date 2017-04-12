package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream input = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        while (input.available() > 0)
        {
            int data = input.read();
            if (!map.containsKey(data))
                map.put(data, 1);
            else
                map.put(data, map.get(data) + 1);
        }
        for (Map.Entry<Integer, Integer> pair: map.entrySet())
        {
            int key = pair.getKey();
            System.out.println((char)key + " " + pair.getValue());
        }
        input.close();
    }
}