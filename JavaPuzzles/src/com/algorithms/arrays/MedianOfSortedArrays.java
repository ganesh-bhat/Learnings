package com.algorithms.arrays;

/**
 * Do simple merge as in mergesort, then based on if array is even/odd, get the middle elem or average of two elem.
 */
public class MedianOfSortedArrays {

    public static float median(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;

        if(n==0 && m ==0) { return  -1; }

        int[] resultant = new int[n+m];

        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m) {
            resultant[k++] = a1[i]<a2[j]?a1[i++]:a2[j++];
        }

        while(i<n ) {
            resultant[k++] = a1[i++];
        }

        while(j<m ) {
            resultant[k++] = a2[j++];
        }


        float median = 0;
        if((n+m)%2 == 0 ) {//even length array
            median = (float)(( resultant[(n+m)/2-1] + resultant[(n+m)/2] )/2.0f);
        } else {//odd length array
            median = resultant[(n+m)/2];
        }

        return median;
    }
}
