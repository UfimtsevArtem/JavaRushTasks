package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {

        String result = "";

        if(n<0) {
            result = "0";
        }
        if(n==0){
            result = "1";
        }
        if(n<=150&&n>0){
            int[] array = new int[n];
            BigInteger num = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                array[i - 1] = i;
            }

            for (int i = 0; i < array.length; i++) {
                num = num.multiply(BigInteger.valueOf(array[i]));
            }
            result = num.toString();
        }
        return result;
    }
}
