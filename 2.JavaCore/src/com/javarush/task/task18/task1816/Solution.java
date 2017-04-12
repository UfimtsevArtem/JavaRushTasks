package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args)throws Exception {
        InputStream in = new FileInputStream(args[0]);
        int count = 0;
        while(in.available()>0){
            int a = in.read();
            if(a>96&&a<123){
                count++;
            }if(a>64&&a<91){
                count++;
            }
        }
        System.out.println(count);
        in.close();
    }
}
