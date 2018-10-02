package com.algorithms.arrays;

import java.util.*;

/**
 * Ref https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
 *
 */
public class UniqueTripletsFormZero {

    public static List<List<Integer>> uniqueTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0;i<arr.length-1;i++) {
            if(i ==0|| i>0 && arr[i]!=arr[i-1]) {//avoid dups
                //do sweep like 2 way sum
                int sum = 0 - arr[i];
                int low = i+1;
                int high = arr.length-1;

                while(low<high) {
                    if(arr[low] + arr[high] == sum) {
                        result.add(Arrays.asList(arr[low], arr[high], arr[i]));
                        while(low<high && arr[low] == arr[low+1]) low++;
                        while(low<high && arr[high] == arr[high-1]) high--;

                        low++; high--;
                    } else if((arr[low] + arr[high]) > sum) {
                        high --;
                    } else {
                        low++;
                    }
                }
            }
        }

        return result;
    }



    }



