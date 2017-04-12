package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static void main(String[] args) throws Exception{
        String fileName = "D:/1.txt";
        int day, month, year;
        Calendar birthdayCalendar = new GregorianCalendar();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        try{
        while (fileReader.ready()){
            String[] oneRow = fileReader.readLine().split(" ");
            year = Integer.parseInt(oneRow[oneRow.length - 1]);
            month = Integer.parseInt(oneRow[oneRow.length - 2]);
            day = Integer.parseInt(oneRow[oneRow.length - 3]);
            birthdayCalendar.set(year,month-1,day);
            String name = oneRow[0];
            for (int i = 1; i < oneRow.length - 3; i++)
                name += " " + oneRow[i];
            PEOPLE.add(new Person(name, birthdayCalendar.getTime()));
        }}catch (Exception e){

        }
        fileReader.close();
    }
}