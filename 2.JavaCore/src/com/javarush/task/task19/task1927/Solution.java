package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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
        String[] result = outputStream.toString().split("\n");
        String text = "JavaRush - курсы Java онлайн";
        String print = "";
        for (int i = 0; i <result.length ; i++) {
            if(i%2==0&&i!=0){
                print += text+"\n";
                print += result[i]+"\n";
            }else{
                print += result[i]+"\n";
            }
        }
        //Возвращаем все как было
        System.setOut(consoleStream);
        System.out.println(print);
        }


    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
