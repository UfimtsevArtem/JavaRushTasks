package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //1. Ввести с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        //2. Найти байт или байты с максимальным количеством повторов.
        ArrayList<Byte> byteList = new ArrayList<>();
        while (fileInputStream.available() > 0){
            int data  = fileInputStream.read();// ВОТ поток FileInputStream читает файл, я не знаю что ещё можно тут предложить валидатору
            byteList.add((byte)data);
        }
        reader.close();
        //Делаем список с количеством повторений байтов на тех же индексах, что и в byteList
        ArrayList<Long> indexList = new ArrayList<>();
        long l = 0;//количество повторений конкретного байта - записываем в indexList
        for (int i = 0; i < byteList.size(); i++) {
            for ( Byte b : byteList ) {
                if (byteList.get(i) == b) {
                    l++;
                }
            }
            indexList.add(l);
            l = 0;
        }
        //узнаем самое большое количество совпадений
        ArrayList<Long> indexSort = new ArrayList<>(indexList);//массив для сортировки
        Collections.sort(indexSort);                           //сортируем по возрастанию
        long countSort = byteList.isEmpty() ? 0 : indexSort.get(indexSort.size() - indexSort.size());  //самое большое количество совпадений - последний элемент в массиве
        //добавляем  в список результат отбора
        ArrayList<Byte> finalBytes = new ArrayList<>();//для результатов
        for (int j = 0; j < indexList.size(); j++) {       //идём по списку с количествами совпадений (индексы в нём соответствуют начальному списку байтов byteList)
            if (indexList.get(j) == countSort){            //если число совпадений равно самому большому количеству совпадений
                if(!finalBytes.contains(byteList.get(j))){ //если в списке результатов ещё нет этого байта,
                    finalBytes.add(byteList.get(j));       //то добавить туда
                }
            }
        }
        //3. Вывести их на экран через пробел.
        for (int j = 0; j < finalBytes.size(); j++) {
            System.out.print(finalBytes.get(j) + " ");
        }
        //4. Закрыть поток ввода-вывода.
        fileInputStream.close();
    }
}