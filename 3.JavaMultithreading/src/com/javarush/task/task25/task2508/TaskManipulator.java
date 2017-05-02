package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                System.out.println(Thread.currentThread().getName());
                thread.sleep(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void start(String threadName) {
        TaskManipulator manipulator = new TaskManipulator();
        thread = new Thread(manipulator);
        thread.setName(threadName);
        thread.start();
    }

    @Override
    public void stop() {
        this.thread.interrupt();
    }
}
