package com.javarush.task.task18.task1813;

import java.io.*;

/*
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream original;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream original) throws IOException
    {
        super(fileName);
        this.original = original;
    }


    @Override
    public void write(int b) throws IOException
    {
        original.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException
    {
        original.write(b);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        original.write(b, off, len);
    }
    @Override
    public void flush() throws IOException
    {
        original.flush();
    }
    @Override
    public void close() throws IOException
    {
        original.flush();
        original.write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }
    public static void main(String[] args) throws IOException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }
}

