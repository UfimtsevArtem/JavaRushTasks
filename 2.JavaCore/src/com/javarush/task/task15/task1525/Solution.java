package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String s;
            while((s = reader.readLine()) !=null){
                lines.add(s);
            }
        }
        catch(Exception e){

        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
