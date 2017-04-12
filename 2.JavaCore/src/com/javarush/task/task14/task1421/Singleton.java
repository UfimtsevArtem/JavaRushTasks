package com.javarush.task.task14.task1421;

/**
 * Created by User on 27.02.2017.
 */
public class Singleton {
    private static Singleton instance; // Создали переменную для хранения единственного экземпляра
    private Singleton(){} // Запретили создание через конструктор
    public static Singleton getInstance(){ // Метод getInstance
        if(instance == null){ // Если переменная пустая, мы создаем новый обьект, заносим в переменную..
            instance = new Singleton();
        }
        return instance; // И возвращаем его.
    }
}
