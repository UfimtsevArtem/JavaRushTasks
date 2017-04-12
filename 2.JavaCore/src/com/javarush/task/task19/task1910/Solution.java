package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(s1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(s2));
        while (reader2.ready()) {
            String s = reader2.readLine();
            writer.write(s.replaceAll("\\p{Punct}", ""));
        }
        reader2.close();
        writer.close();
    }
}
