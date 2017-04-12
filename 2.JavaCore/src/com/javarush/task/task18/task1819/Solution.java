package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        InputStream in1 = new FileInputStream(name1);
        while(in1.available()>0){
            list1.add(in1.read());
        }
        OutputStream out = new FileOutputStream(name1);
        InputStream in2 = new FileInputStream(name2);

        byte[] arr = new byte[1000];
        while(in2.available()>0){
            list2.add(in2.read());
        }
        for (Integer a:list2) {
            out.write(a);
        }for (Integer a:list1) {
            out.write(a);
        }
        in1.close();
        in2.close();
        out.close();
    }
}
