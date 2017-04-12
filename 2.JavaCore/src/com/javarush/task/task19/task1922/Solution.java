package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = args[0];
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(s));
        while(file.ready()){
            String text = file.readLine();
            String[] strings = text.split(" ");
            int count = 0;
            for (String v : words)
            {
                for (String l : strings)
                {
                    if (l.equals(v))
                    {
                        count++;
                    }
                }
            }
            if(count==2){
                System.out.println(text);
            }
        }

        file.close();

    }
}
