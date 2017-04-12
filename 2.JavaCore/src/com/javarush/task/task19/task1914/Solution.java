package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        int a,b;
        int c = 0;
        String[] array = outputStream.toString().split(" ");
        a = Integer.parseInt(array[0]);
        b = Integer.parseInt(array[2]);
        if(array[1].equals("+"))
            c = a + b;
        if(array[1].equals("-"))
            c = a - b;
        if(array[1].equals("*"))
            c = a * b;
        String result = a+" "+array[1]+" "+b+" = "+c;

        //Возвращаем все как было
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

