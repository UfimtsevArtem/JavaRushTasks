package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        while(reader.ready()){
            String text = reader.readLine();
            String[] strings = text.split(" ");
            for (int i = 0; i <strings.length ; i++) {
                if(checkString(strings[i]))
                    writer.write(strings[i]+" ");
            }
        }
        reader.close();
        writer.close();
    }
    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;
        char c;
        for (int i = 0; i< string.length(); i++) {
            c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }
}
