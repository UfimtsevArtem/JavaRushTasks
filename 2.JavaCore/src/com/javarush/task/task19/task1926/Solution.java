package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader("D:/1.txt"));
        while(reader1.ready()){
            System.out.println(new StringBuffer(reader1.readLine()).reverse().toString());
        }
        reader1.close();
    }
}
