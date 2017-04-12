package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(s));
        int count = 0;
        while(fileReader.ready()){
            String text = fileReader.readLine();
            String[] array = text.toLowerCase().split("(\\W)+");
            for (String a :array) {
                if(a.equals("world"))
                    count++;
            }
        }
        System.out.println(count);
        fileReader.close();
    }
}
