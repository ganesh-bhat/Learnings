package com.common.java;

public class ArrayQuestions {


    public static int findPeakLinear(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            return array[0];
        }
        if(array.length == 2) {
            return array[0]> array[1]?array[0]:array[1];
        }

        for(int i=1;i<array.length-1;i++) {
            if(array[i] > array[i-1] && array[i] > array[i+1]) {
                return array[i];
            }
        }
        return 0;
    }

    public static void rotateArray(int[] array, int count) {
        int len = array.length;

        int[] temp = new int[count];
        int srcStart = len-count;
        for(int i= 0 ; i<count ;i++) {
            temp[i] = array[srcStart+i];
        }

        int lastIdx = len-1;
        int startIndex = len-count-1;

        for(int i= 0 ; i< ( len-count ) ;i++) {
            array[lastIdx--] = array[startIndex--];
        }

        for(int i= 0 ; i<count ;i++) {
            array[i] = temp[i];
        }

    }





}
