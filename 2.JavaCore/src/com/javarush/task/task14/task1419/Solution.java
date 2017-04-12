package com.javarush.task.task14.task1419;

import sun.misc.ExtensionInstallationException;

import java.io.EOFException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.RejectedExecutionException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new RuntimeException());
        exceptions.add(new IOException());
        exceptions.add(new ExtensionInstallationException("s"));
        exceptions.add(new ConcurrentModificationException());
        exceptions.add(new DuplicateFormatFlagsException("D"));
        exceptions.add(new EOFException());
        exceptions.add(new RejectedExecutionException());
        exceptions.add(new TooManyListenersException());
        exceptions.add(new RejectedExecutionException());

    }
}
