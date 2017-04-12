package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = null;
        String fileName;
        File file;
        while (true) {
            fileName = in.readLine();

            try {
                inputStream = new FileInputStream(fileName);

            } catch (FileNotFoundException e) {
                System.out.print(fileName);
                //in.close();
                break;
            } finally {
                try {
                    if(inputStream!=null)
                    inputStream.close();
                } catch (IOException e) {
                }

                //break;
            }
        }
        in.close();
    }
}