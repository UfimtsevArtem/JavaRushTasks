package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber=="" || telNumber==null) return false;
        if (telNumber.matches("(-).*")) return false;
        else if(telNumber.matches("^(\\+{1})(\\d*\\(\\d{3}\\))?(\\d)*(-)?(\\d)*(\\d+-)?(\\d)+") && telNumber.matches("(\\D*\\d){12}")) return true;
        else if(telNumber.matches("(\\(\\d{3}\\))?(\\d+\\(\\d{3}\\))?(\\d)*(-)?(\\d)*(\\d+-)?(\\d)+") && telNumber.matches("(\\D*\\d){10}")) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+3-805012345-67"));
    }
}
