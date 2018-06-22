package com.learning.algorithms.sorting;

import java.util.Arrays;

/**
 * Created by ganes on 09-06-2018.
 * https://www.youtube.com/watch?v=TTnvXY82dtM
 *
 * https://www.geeksforgeeks.org/counting-sort/
 *
 * basis for radix sort, useful when the numbers are small in range
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] numbers = {4,6,1,2,5,8,9,7};

        countingSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void countingSort(int[] numbers) {

        int min = numbers[0];
        int max = numbers[0];
        for(int i=0;i<numbers.length;i++) {
            if(numbers[i]>max) {
                max = numbers[i];
            }
            if(numbers[i]<min) {
                min = numbers[i];
            }
        }

        int[] count = new int[max+1];
        int[] result = new int[max+1];

        for(int i=0;i<numbers.length;i++) {
            int num = numbers[i];
            count[num]+=1;
        }

        for(int i=min+1;i<=max;i++) {
            count[i]=count[i-1]+count[i];
        }

        for(int i=0;i<numbers.length;i++) {
            result[count[numbers[i]]] = numbers[i];
        }

        for(int i=min,j=0;i<numbers.length;i++,j++) {
            numbers[j] = result[i];
        }


    }

}
