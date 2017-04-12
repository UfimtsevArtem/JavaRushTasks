package com.javarush.task.task18.task1815;

import javafx.scene.control.Tab;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        ATableInterface aTableInterface;
        public TableInterfaceWrapper(ATableInterface aTableInterface) {
            this.aTableInterface = aTableInterface;
        }
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            aTableInterface.setModel(rows);
        }
        @Override
        public String getHeaderText() {
            return aTableInterface.getHeaderText().toUpperCase();
        }
        @Override
        public void setHeaderText(String newHeaderText) {
            aTableInterface.setHeaderText(newHeaderText);
        }
    }
    public interface ATableInterface {
        void setModel(List rows);
        String getHeaderText();
        void setHeaderText(String newHeaderText);
    }
}