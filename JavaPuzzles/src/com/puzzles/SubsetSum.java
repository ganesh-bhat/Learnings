package com.puzzles;

/**
 * Created by ganes on 20-06-2018.
 */
public class SubsetSum {


    public static void main(String[] args) {
        int[] numbers = {5,13,6, 5,15,12,7};
        int sum = 32;

        int total = 0;
        for(int i=0;i<numbers.length;i++) {
            total+=numbers[i];
        }

        findSubset(numbers,"", numbers.length, sum,0, total);


    }


    private static void findSubset(int[] set, String subset, int n,int sum, int subsetSum, int remains) {

        if(n <= 0) {
            return;
        }

        if(subsetSum > sum ) {
            return;
        }

        if(subsetSum+remains < sum) {
            return;
        }

        if(subsetSum == sum) {
            System.out.println("found solution:"+subset);
            return;
        }

        findSubset(set, subset, n-1,sum,subsetSum, remains-set[n-1]);

        findSubset(set, subset+","+set[n-1], n-1,sum,subsetSum+set[n-1], remains-set[n-1]);

    }


   }
