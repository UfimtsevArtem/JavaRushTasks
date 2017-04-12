package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<Integer> array = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
            while (in.ready()) {
                int i = Integer.parseInt(in.readLine());
                if (i % 2 == 0)
                    array.add(i);
            }
        } catch (NumberFormatException ignore) {/*NOP*/}
        bubbleSort(array);
        for (int a:array) {
            System.out.println(a);
        }

    }
    public static void bubbleSort(ArrayList<Integer> array) {
        int j;
        boolean flag = true;   // устанавливаем наш флаг в true для первого прохода по массиву
        int temp;   // вспомогательная переменная

        while (flag) {
            flag = false;    // устанавливаем флаг в false в ожидании возможного свопа (замены местами)
            for (j = 0; j < array.size() - 1; j++) {
                if (array.get(j) > array.get(j + 1)) { // измените на > для сортировки по возрастанию
                    temp = array.get(j);         // меняем элементы местами
                    array.set(j, array.get(j+1));
                    array.set(j+1,temp);
                    flag = true;  // true означает, что замена местами была проведена
                }
            }
        }
    }

}

