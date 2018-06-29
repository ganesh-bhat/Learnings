package com.algorithms.sorting;

public class MergeSort {

    public static void sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        mergeSort(array, aux, 0 , array.length-1);
    }

    private static void mergeSort(Comparable[] array, Comparable[] aux, int low, int high) {
        if(high<=low) {
            return;
        }

        int mid = low+ (high-low)/2;
        mergeSort(array,aux,low,mid);
        mergeSort(array,aux,mid+1,high);
        merge(array, aux, low, mid,high);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        for(int k = low;k<=high; k++) {
            aux[k] = arr[k];
        }
        int i = low;
        int j = mid+1;

        for(int k=low;k<=high;k++) {
            if(i>mid) {
                arr[k] = aux[j++];
            } else if(j>high){
                arr[k] = aux[i++];
            } else {
                if(compare(aux[j], aux[i]) < 0 ) {
                    arr[k] = aux[j++];
                } else {
                    arr[k] = aux[i++];
                }
            }
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
        return aux.compareTo(aux1);
    }

}
