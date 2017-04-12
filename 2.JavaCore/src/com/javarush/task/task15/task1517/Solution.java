package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        int c;
        int a = 1;
        int b = 0;
        c = a / b;
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
