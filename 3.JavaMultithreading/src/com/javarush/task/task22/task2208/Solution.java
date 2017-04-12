package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,String>pair:params.entrySet()) {
            if(pair.getValue() != null){
                if(result.length()==0){
                    result.append(pair.getKey()+" = '"+pair.getValue()+"'");
                }
                else{
                    result.append(" and "+pair.getKey()+" = '"+pair.getValue()+"'");
                }
            }
        }
        return result.toString();
    }
}
