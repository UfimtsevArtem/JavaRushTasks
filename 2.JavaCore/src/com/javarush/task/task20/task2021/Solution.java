package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
          throw new NotSerializableException();
        }private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException{
          throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
