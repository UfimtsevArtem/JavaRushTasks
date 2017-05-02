package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{13, 8, 15, 5, 17, 25};
        sort(array);

    }

    public static Integer[] sort(Integer[] array) {
        class mInt implements Comparable<mInt>
        {
            int value;
            mInt(int value)
            {
                this.value = value;
            }
            @Override
            public int compareTo(mInt o)
            {
                return this.value - o.value;
            }
        }
        ArrayList<mInt> m = new ArrayList<mInt>( );
        for (Integer i : array) m.add (new mInt (i));
        Collections.sort (m);
        double mediana;
        if(array.length%2==0)   {
            mediana = (m.get (array.length / 2).value + m.get (array.length / 2 - 1).value) / 2.;
        }
        else
        {
            mediana = m.get (array.length / 2).value;
        }
        Comparator<mInt> compareByHeight = new Comparator<mInt> ( )
        {
            public int compare(mInt o1, mInt o2)
            {
                return (int) (Math.abs (o1.value - mediana) - Math.abs (o2.value - mediana));
            }
        };
        Collections.sort (m, compareByHeight);
        for (int i = 0; i < array.length; i++)
            array[i] = m.get (i).value;
        return array;
    }
}
