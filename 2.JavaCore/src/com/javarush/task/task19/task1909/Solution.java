package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(s1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(s2));
        int count = 0;
        while (reader2.ready()) {
            int s = reader2.read();
            if(s == 46){
                writer.write(33);
            }else
            writer.write(s);
        }
        reader2.close();
        writer.close();
    }
}
