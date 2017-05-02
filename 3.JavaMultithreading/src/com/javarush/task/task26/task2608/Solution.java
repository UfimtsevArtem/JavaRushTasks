package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать
*/
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;

    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        Integer sum12 = 0;
        synchronized (sum12){
            sum12 = var1 + var2;
        }
        return sum12;
    }

    public int getSumOfVar3AndVar4(){
        Integer sum34 = 0;
        synchronized (sum34){
            sum34 = var3 + var4;
        }
        return sum34;
    }

    public static void main(String[] args) {

    }
}
