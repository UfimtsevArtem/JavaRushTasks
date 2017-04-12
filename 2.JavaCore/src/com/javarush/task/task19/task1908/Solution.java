package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(s1));
        BufferedWriter writer =new BufferedWriter(new FileWriter(s2));
        int count = 0;
        while(reader2.ready()){
            String s = reader2.readLine();
            String[] text = s.split(" ");
            for (String a:text) {
                if(checkString(a)){
                   writer.write(a+" ");
                }
            }
        }
        reader2.close();
        writer.close();

    }
    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
