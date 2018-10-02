package com;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static void swap(int[] arr, int i1, int i2) {
        if(i2 < arr.length && i1< arr.length) {
            int temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
        }
    }

    public static void generateTwoDimenPathMatrix(int dimen) {
        int[][] matrix = new int[dimen][dimen];
        Random rand = new Random();
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                matrix[i][j] = rand.nextInt(2);
            }
        }

        System.out.println(Arrays.deepToString(matrix).replaceAll("],","},\n").replaceAll("\\[","{").replaceAll("]]","}}"));
    }

    public static void prettyPrintBooleanMatrix(boolean[][] array, String trueValue, String falseValue) {
        System.out.println(Arrays.deepToString(array)
                .replaceAll("true",trueValue).replaceAll("false",falseValue)
                .replaceAll("],","]\n")
                .replaceAll("\\[\\["," [")
                .replaceAll("]]","]"));
        System.out.println("");
    }

}
