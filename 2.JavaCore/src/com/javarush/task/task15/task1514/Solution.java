package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
static{
    labels.put(2d,"ds");
    labels.put(6d,"dwsfs");
    labels.put(1d,"dsefs");
    labels.put(4d,"dqwes");
    labels.put(3d,"dsfd");
}
    public static void main(String[] args) {

        System.out.println(labels);
    }
}
