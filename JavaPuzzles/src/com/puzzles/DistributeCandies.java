package com.puzzles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public static void main(String[] args) {

    }

    public int distributeCandies(int[] candies) {
        if(candies == null || candies.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int candy:candies) {
            set.add(candy);
            if(set.size() >= candies.length / 2){
                return candies.length / 2;
            }
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }

}
