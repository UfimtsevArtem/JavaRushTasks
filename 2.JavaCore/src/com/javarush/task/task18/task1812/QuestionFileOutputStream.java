package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    public AmigoOutputStream original;
    QuestionFileOutputStream(AmigoOutputStream amigo){
        this.original = amigo;
    }
    public void flush() throws IOException{
        original.flush();
    }

    public void write(int b) throws IOException{
        original.write(b);
    }

    public void write(byte[] b) throws IOException{
        original.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException{
        original.write(b,off,len);
    }

    public void close() throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        if(answer.equals("Д")){
            original.close();
            reader.close();

        }
    }
}

