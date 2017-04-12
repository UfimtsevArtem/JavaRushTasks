package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
    }
    public static String [] getTokens(String query, String delimiter){
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] array;
        StringBuilder builder = new StringBuilder();
        while(tokenizer.hasMoreTokens()){
            builder.append(tokenizer.nextToken() + " ");
        }
        array = builder.toString().split(" ");
        return array;
    }
}
