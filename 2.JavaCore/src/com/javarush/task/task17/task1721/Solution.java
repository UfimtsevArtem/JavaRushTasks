package com.javarush.task.task17.task1721;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while (file1.ready()) allLines.add(file1.readLine());
        while (file2.ready()) forRemoveLines.add(file2.readLine());
        file1.close();
        file2.close();
        Solution solution = new Solution();
        try {
            solution.joinData();
        }
        catch (CorruptedDataException e) {
        }
    }
    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.removeAll(allLines);
                throw new CorruptedDataException();
            }

    }
}
