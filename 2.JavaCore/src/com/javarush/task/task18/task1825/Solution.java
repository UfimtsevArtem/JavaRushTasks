package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        ArrayList<String> list = new ArrayList<>();
        while(true){
            s = reader.readLine();
            if(s.equals("end"))
                break;
            list.add(s);
        }
        Collections.sort(list);
        String filename = list.get(0);
        String newFile = filename.toString().substring(0, filename.lastIndexOf("."));
        OutputStream out = new FileOutputStream(newFile);
        BufferedReader inn;
        for (String a :list) {
            inn = new BufferedReader(new FileReader(a));
            int c;
            while((c = inn.read())!= -1){
                out.write(c);
            }
            inn.close();
        }
        reader.close();
        out.close();
    }
}
