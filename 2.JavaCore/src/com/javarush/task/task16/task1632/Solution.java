package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
static{
    Thread thread1 = new TestThread1();
    Thread thread2 = new TestThread2();
    Thread thread3 = new TestThread3();
    Thread thread4 = new TestThread4();
    Thread thread5 = new TestThread5();
    threads.add(thread1);
    threads.add(thread2);
    threads.add(thread3);
    threads.add(thread4);
    threads.add(thread5);

}
    public static void main(String[] args) throws Exception {

    }
    public static class TestThread5 extends Thread{

        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String N = "exit";
            int sum = 0;
            String s;
            try {
                while (true) {
                    s = reader.readLine();
                    int a= Integer.parseInt(s);
                    if(s.equals(N)) {
                        break;
                    }
                    sum = sum + a;
                }

            }catch(Exception e){

            }
            System.out.println(sum);
        }
    }public static class TestThread1 extends Thread{
        public void run(){
            while(true){

            }
        }
    }public static class TestThread4 extends Thread implements Message{
        public void showWarning() {
            this.interrupt();
        }
        @Override
        public void run() {
            //showWarning();
            super.run();
        }
    }

    public static class TestThread3 extends Thread{
        public void run(){
            try{
                while(true){
                    System.out.println("Ура");
                    Thread.sleep(500);}

            }catch(Exception e){

            }
        }
    }
    public static class TestThread2 extends Thread{
        public void run(){
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                System.out.println("InterruptedException");
            }

        }
    }
}