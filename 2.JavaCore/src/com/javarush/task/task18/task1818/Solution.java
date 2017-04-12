package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        reader.close();
        OutputStream in1 = new FileOutputStream(name1);
        InputStream in2 = new FileInputStream(name2);
        InputStream in3 = new FileInputStream(name3);

        while(in2.available()>0){
            in1.write(in2.read());
        }
        while(in3.available()>0){

            in1.write(in3.read());

        }
        in1.close();
        in2.close();
        in3.close();
    }
}
