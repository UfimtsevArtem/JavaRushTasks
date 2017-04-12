package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a,b,c;
        int nod = 0;
        int temp;
        temp = Integer.parseInt(reader.readLine());
        if(temp>0)
            a = temp;
        else
            throw new NumberFormatException("бомбом");
        temp = Integer.parseInt(reader.readLine());
        if(temp>0)
            b = temp;
        else
            throw new NumberFormatException("бомбом");
        if(a>b)
            c = b;
        else
            c = a;
        for (int i = c; i >0 ; i = i-1) {
            if(a%i==0&&b%i==0){
                nod = i;
                break;
            }
        }
        System.out.println(nod);
    }
}
