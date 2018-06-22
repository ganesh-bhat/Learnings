package com.puzzles;

import java.util.Arrays;

public class MaxDiffInArray {

    public static void main(String[] args) {
        int[] numbers = {4,8,5,1,6,3,9,2};
        Arrays.sort(numbers);

        int[][] result = new int[2][numbers.length/2];
        System.arraycopy(numbers,0,result[0],0, (numbers.length/2));
        System.arraycopy(numbers,(numbers.length/2),result[1],0, (numbers.length/2));

        System.out.println(Arrays.toString(result[0]));
        System.out.println(Arrays.toString(result[1]));
    }
}
