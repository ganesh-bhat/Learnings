package com.algorithms.search;


public class RotatedArrayQuestions {


    /**
     * find max elem in sorted rotated array
     */
    public static int findMaxElem(int[] array) {

        int left = 0;
        int right = array.length-1;

        while(left<=right) {
            int mid = (left+right)/2;

            if(mid-1 < 0) {
                if(array[mid] > array[mid+1]) {
                    return array[mid];
                }
            }
            if(array[mid] > array[mid+1] &&
                    array[mid]> array[mid-1]) {
                return array[mid];
            } else if(array[mid] > array[mid-1]) {
                left = mid+1;
            } else {
                if((array[mid] > array[0])) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }

            }
        }
        return -1;
    }

    /**
     * find elem in sorted rotated array
     */
    public static int find(int[] array, int elem) {

        int left = 0;
        int right = array.length-1;

        while(left<=right) {
            int mid = (left+right)/2;
            if(mid < 0 || mid >= array.length) {
                break;
            }
            if(array[mid] == elem) {
                return mid;
            } else if(array[mid] > elem &&
                    array[right]<  elem) {
                right = mid-1;
            } else if(array[mid] > elem && array[right]>= elem || array[mid] < elem) {
                left = mid+1;
            }
        }
        return -1;
    }





}
