package com.algorithms.arrays;

import com.Utils;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {

    public static void shuffle(int[] arr) {
        Random ran = new Random();

        for(int i=arr.length-1;i>=0;i--) {
            int randomIndex = ran.nextInt(i+1);
            Utils.swap(arr, i, randomIndex);
        }
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        shuffle(arr);
        System.out.println(Arrays.toString(arr));

    }

}
