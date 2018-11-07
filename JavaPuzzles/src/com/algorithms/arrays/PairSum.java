package com.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairSum {


    public static void pairSum(int[] arr, int sum) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(sum - arr[i])) {
                //can put into an object and print later as well.
                System.out.println(arr[i]+"+"+(sum - arr[i]) +"=" + sum +"found at :"+i+","+map.get(sum - arr[i])+" index");
            }
            map.put(arr[i],i);
        }

    }

    public static void main(String[] args) {
        int[] arr = {8,7,2,2,3,1};
        pairSum(arr, 10);
    }
}
