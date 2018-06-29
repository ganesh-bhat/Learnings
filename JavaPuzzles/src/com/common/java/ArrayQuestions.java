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


    public static<T> void rotate(T[] arr) {
        T temp = arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--) {
            arr[i] = arr[i-1];
        }

        arr[0] = temp;
    }

    public static<T> void rotate(T[] arr, int count) {
        for(int i=0;i<count;i++) {
            rotate(arr);
        }
    }

    public static<T> void exchangeDiagonals(T[][] arr) {
        for(int i=0;i<arr.length;i++) {
            swap(arr, i, i, i, arr.length-1-i);
        }
    }

    private static<T> void swap(T[][] arr, int x1, int y1, int x2, int y2) {
        T temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;

    }



}
