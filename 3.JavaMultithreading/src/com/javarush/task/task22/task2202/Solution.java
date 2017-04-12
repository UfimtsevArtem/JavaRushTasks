package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }


    public static String getPartOfString(String string) {
        if(string == null)
            throw new TooShortStringException();
        String[] array = string.split(" ");
        if(array.length<5)
            throw new TooShortStringException();
        return array[1]+" "+array[2]+" "+array[3]+" "+array[4];
    }
    public static class TooShortStringException extends RuntimeException{

    }
}
