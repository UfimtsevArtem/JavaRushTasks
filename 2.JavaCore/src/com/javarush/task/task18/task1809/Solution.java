package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream file = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        List<Integer> list = new ArrayList<>();

        while(file.available()>0){
            list.add(file.read());
        }


        for (int i = list.size()-1; i >=0 ; i--) {
            file2.write(list.get(i));
        }
        file.close();
        file2.close();
    }
}