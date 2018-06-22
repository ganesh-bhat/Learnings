package com.algorithms.recursion;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ganes on 19-05-2018.
 */
public class Sorting {

    public static void main(String[] args) {

        int [] ints = {2,4,5,7,5,3,1,6};
        Integer[] boxedInts = IntStream.of(ints).boxed().toArray(Integer[]::new);
       // bubbleSort(boxedInts);
        recursiveBubbleSort(boxedInts,boxedInts.length);

        System.out.println(Arrays.toString(boxedInts));
    }

    static<T extends Comparable> void bubbleSort(T[] data) {
        T temp;
        for(int i=0;i<data.length;i++) {
            for(int j=0;j<data.length-1-i;j++) {
                if(data[j].compareTo(data[j+1]) > 0) {
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    static<T extends Comparable> void recursiveBubbleSort(T[] data, int n) {

        if(n < 0) {
            return;
        }

        T temp;
        for(int j=0;j<n-1;j++) {
            if(data[j].compareTo(data[j+1]) > 0) {
                temp = data[j];
                data[j] = data[j+1];
                data[j+1] = temp;
            }
        }
        recursiveBubbleSort(data,n-1);
    }


}
