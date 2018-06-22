package com.learning.algorithms.sorting;

import java.util.Arrays;

/**
 * When N guaranteed to be small - O(N^2) , best is O(N)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = {4,6,1,2,5,8,9,7};

        insertSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void insertSort(int[] array) {

        for(int i=1;i<array.length;i++) {
            int num = array[i];
            int numIndex = i;
            for(int j=i-1;j>=0;j--) {
                if(array[j]>num) {
                    array[numIndex] = array[j];
                    numIndex = j;
                    //delay the actual value updation, keep moving numbers next..
                }
            }
            //finally move the number to its right place
            array[numIndex] = num;
        }
    }
}
