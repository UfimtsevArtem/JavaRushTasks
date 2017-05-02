package com.javarush.task.task27.task2710;

import java.util.Objects;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long beforeTime = System.currentTimeMillis();
        synchronized (mail) {
            try {
                while (Objects.equals(mail.getText(), null)) {
                    mail.wait();
                }
                String name = Thread.currentThread().getName();
                long afterTime = System.currentTimeMillis();
                System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
                mail.setText(null);
                mail.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
