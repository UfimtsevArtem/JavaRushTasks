package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }
        catch (IOException e){e.printStackTrace();}
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }
    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }
    public interface ReadFileInterface {
        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }
    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface
    {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader fileReader;
        @Override
        public void setFileName(String fullFileName) {
            try {
                fileReader = new BufferedReader(new FileReader(fullFileName));
            }
            catch (FileNotFoundException e) {e.printStackTrace();}
        }
        @Override
        public String getFileContent() {
            return stringBuffer.toString();
        }
        @Override
        public void run() {

            try{

                while (fileReader.ready())
                {
                    String line = fileReader.readLine();
                    stringBuffer.append(line);
                    stringBuffer.append(" ");
                }
                fileReader.close();
            }
            catch (IOException e){e.printStackTrace();}
        }
    }
}