package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));

        while (reader1.ready()) {
            list.add(reader1.readLine());
        }
        if (args[0].equals("-c")) {
            String lastString = list.get(list.size() - 1);
            int idOfLastString = Integer.parseInt(lastString.substring(0, 8).replaceAll(" ", ""));
            int idOfNewStringInt = idOfLastString + 1;

            list.add(String.format(Locale.ENGLISH,"%-8d%-30.30s%-8s%-4s", idOfNewStringInt, args[1], Float.parseFloat(args[2]), args[3]));

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
            }
            reader.close();
            reader1.close();
            writer.close();
        }
    }
}
