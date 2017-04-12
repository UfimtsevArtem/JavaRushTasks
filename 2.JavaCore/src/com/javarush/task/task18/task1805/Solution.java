package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //1. Ввести с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        //2. Найти байт или байты с максимальным количеством повторов.
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0){
            int data  = fileInputStream.read();// ВОТ поток FileInputStream читает файл, я не знаю что ещё можно тут предложить валидатору
            map.put(data,1);
        }
        fileInputStream.close();
        for (Map.Entry<Integer,Integer>pair:map.entrySet()) {
            list.add(pair.getKey());
        }
        Collections.sort(list);
        for (int a:list) {
            System.out.print(a + " ");
        }
    }
}
