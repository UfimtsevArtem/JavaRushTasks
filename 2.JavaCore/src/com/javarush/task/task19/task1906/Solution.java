package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        FileReader reader2 = new FileReader(s1);
        FileWriter writer = new FileWriter(s2);
        int count = 0;
        while(reader2.ready()){
            int data = reader2.read();
            count++;
            if(count%2==0){
                writer.write(data);
            }
        }
        reader.close();
        reader2.close();
        writer.close();
    }
}
