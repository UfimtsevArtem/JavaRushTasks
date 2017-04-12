package com.javarush.task.task18.task1808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/*
Разделение файла
*/
public class Solution {
    public static void main(String[] args)throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream file = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);
        byte[] num = new byte[20000];
        while(file.available()>0){
            int a = file.read(num);
            if(a%2==0){

                file2.write(num,0,(a/2));
                file3.write(num,(a/2),a-((a/2)));
            }else
            {
                file2.write(num,0,(a/2)+1);
                file3.write(num,(a/2)+1,a-((a/2)+1));
            }
        }
        file.close();
        file2.close();
        file3.close();
    }
}
