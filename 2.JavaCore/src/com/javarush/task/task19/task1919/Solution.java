package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static TreeMap<String,Double> list = new TreeMap<>();
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while(reader.ready()){
            String[] s = reader.readLine().split(" ");
            if(list.containsKey(s[0])){
                list.put(s[0],list.get(s[0])+Double.parseDouble(s[1]));
            }else{
                list.put(s[0],Double.parseDouble(s[1]));
            }
        }
        reader.close();
        for (Map.Entry<String,Double>pair:list.entrySet()) {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
    }
}
