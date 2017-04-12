package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = reader.readLine();
            if(s.equals("exit"))
                break;
            ReadThread thread = new ReadThread(s);
            thread.start();
        }
        reader.close();
    }

        public static class ReadThread extends Thread{
            public String name;
            public ReadThread(String fileName) {
            this.name = fileName;
            }
        public void run(){
            int max = 0;
            try {
                FileInputStream input = new FileInputStream(name);
                TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
                while (input.available() > 0)
                {
                    int data = input.read();
                    if (!map.containsKey(data))
                        map.put(data, 1);
                    else
                        map.put(data, map.get(data) + 1);
                }
                for (Map.Entry<Integer,Integer>pair:map.entrySet()) {
                    if(pair.getValue()>max)
                        max = pair.getValue();
                }for (Map.Entry<Integer,Integer>pair:map.entrySet()) {
                    if(pair.getValue()==max)
                        resultMap.put(name,pair.getKey());
                }
                input.close();
            }
            catch(Exception e){

            }

        }
    }
}
