package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args)throws Exception {
        //Считать с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        int id = Integer.parseInt(args[0]);
        reader.close();
        //Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
        BufferedReader br = new BufferedReader(new FileReader(path));
        while(br.ready()){
            String s = br.readLine();
            if(s!=null)
                break;
            if(id == Integer.parseInt(s.split(" ")[0])){
                System.out.println(s);
                br.close();
                break;
            }
        }

    }
}
