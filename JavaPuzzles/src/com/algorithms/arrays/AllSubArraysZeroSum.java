package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllSubArraysZeroSum {

    private static void insert( Map<Integer, List<Integer>> map, int sum, int index) {
        if(!map.containsKey(sum)) {
            map.put(sum, new ArrayList<>());
        }
        map.get(sum).add(index);
    }


    private static void printSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        insert(map, 0, -1);

        int sum =0;
        for(int i=0;i<arr.length;i++) {
            sum+=arr[i];
            if(map.containsKey(sum)) {
                for(int val:map.get(sum)) {
                    System.out.println("subarry ["+(val+1)+".."+i+"]");
                }
            }
            insert(map, sum, i);
        }
    }


    public static void main(String[] args) {
        int[] A = { 4,-6,3,-1,4,2,7 };

        printSubarrays(A);

    }
}
