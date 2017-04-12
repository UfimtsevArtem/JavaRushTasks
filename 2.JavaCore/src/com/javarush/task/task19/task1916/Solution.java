package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

        public static void main(String[] args) throws Exception {
            BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
            String file1 = fileName.readLine();
            String file2 = fileName.readLine();
            fileName.close();

            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();

            BufferedReader readerFile1 = new BufferedReader(new FileReader(file1));
            BufferedReader readerFile2 = new BufferedReader(new FileReader(file2));

            while (readerFile1.ready())
            {
                list1.add(readerFile1.readLine());
            }
            readerFile1.close();

            while (readerFile2.ready())
            {
                list2.add(readerFile2.readLine());
            }
            readerFile2.close();

            for (int i = 0, j = 0; i < list1.size()-1 || j < list2.size()-1; i++, j++) {
                if(list1.get(i).equals(list2.get(j))){
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                }else if(list1.get(i).equals(list2.get(j+1))){
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    i--;
                }
                else if(list1.get(i+1).equals(list2.get(j))){
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    j--;
                }

                    if(i == list1.size()-2&& j == list2.size()-1) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i+1)));
                    }
                    if(i == list1.size()-1&& j == list2.size()-2) {
                        lines.add(new LineItem(Type.ADDED, list2.get(j+1)));
                    }
                }

            for (LineItem l : lines)
            {
                System.out.println(l.type + " " + l.line);
            }
        }


        public static enum Type {
            ADDED,        //добавлена новая строка
            REMOVED,      //удалена строка
            SAME          //без изменений
        }

        public static class LineItem {
            public Type type;
            public String line;

            public LineItem(Type type, String line) {
                this.type = type;
                this.line = line;
            }
        }
    }

