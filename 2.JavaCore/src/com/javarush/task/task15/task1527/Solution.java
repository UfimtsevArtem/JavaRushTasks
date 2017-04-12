package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String allArguments = s.substring(s.indexOf("?") + 1);
        String[] parsed = allArguments.split("&");
        for (int i = 0; i < parsed.length; i++) {
            String currentArg = parsed[i];
            String[] currentArgArr = parsed[i].split("=");
            if(i == parsed.length - 1){
                System.out.print(currentArgArr[0]);
            }else{
                System.out.print(currentArgArr[0] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < parsed.length; i++) {
            String currentArg = parsed[i];
            String[] currentArgArr = parsed[i].split("=");
            if(currentArgArr[0].equals("obj")){
                try {
                    alert(Double.parseDouble(currentArgArr[1]));
                }
                catch(Exception e){
                    alert(currentArgArr[1]);
                }
            }
        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }
    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
