package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream stream = new FileInputStream(args[0]);
        int count = 0;
        int countSpace = 0;
        while(stream.available()>0){
            int a = stream.read();
            count++;
            if(a == 32)
                countSpace++;
                }

        stream.close();
        double dev = ((double) countSpace/ count) * 100;
        dev = dev * 100;
        int i = (int) Math.round(dev);
        dev = (double)i / 100;
        System.out.println(dev);
    }
}
