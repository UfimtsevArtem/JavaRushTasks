package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(name1));
        OutputStream out = new FileOutputStream(name2);
        List<String[]> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while(in.ready()){
                list1.add(in.readLine().split(" "));
        }
        for (String[] d:list1) {
            for (int i = 0; i <d.length; i++) {
                list2.add((int)(Math.round(Double.parseDouble(d[i]))));
            }
        }
        String s = "";
        for (Integer i:list2) {
            s +=i;
            s +=" ";
        }
        byte[] b = s.getBytes();
        out.write(b);
        in.close();
        out.close();
    }
}
