package com.algorithms.search;

public class BinarySearch {

    public static int search(Comparable[] array, Comparable data) {
        return binarySearch(array, data, 0, array.length-1);
    }
    public static int iterativeSearch(Comparable[] array, Comparable data) {
        int low = 0;
        int high = array.length-1;

        while(low>=0 && high < array.length && low<=high) {
            int mid = (high+low)/2;
            if(compare(array[mid], data) == 0) {
                return mid;
            } else if(compare(array[mid], data) < 0) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }



    private static int binarySearch(Comparable[] array, Comparable data, int low, int high) {

        if(low> high || low<0 || high >= array.length) {
            return -1;
        }
        int mid = (low+high)/2;
        if(compare(array[mid], data) == 0) {
            return mid;
        } else if(compare(array[mid], data) < 0) {
            return binarySearch(array,data,mid+1, high);
        } else {
            return binarySearch(array,data,low, mid-1);
        }
    }

    private static int compare(Comparable aux, Comparable aux1) {
        if(aux == null & aux1 == null) {
            return 0;
        } else if(aux1 ==null) {
            return 1;
        } else if(aux == null) {
            return -1;
        }
        return aux1.compareTo(aux);
    }

}
