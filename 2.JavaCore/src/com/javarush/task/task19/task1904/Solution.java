package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        PersonScannerAdapter(Scanner scanner){
            this.fileScanner = scanner;
        }
        public Person read() throws IOException{
            String str = fileScanner.nextLine();
            String[] s = str.split(" ");
            int year, month, day;
            year=Integer.parseInt(s[5]);
            month = Integer.parseInt(s[4])-1;
            day=Integer.parseInt(s[3]);
            Date date= (new GregorianCalendar(year,month, day)).getTime();
            Person person =  new Person(s[1], s[2], s[0], date);
            return person;
        }
        public void close() throws IOException{
            this.fileScanner.close();
        }
    }
}
