package com.algorithms.arrays;

public class FindEquilibrium {


    private static void findEquilibrium(int[] arr) {

        int totalSum = 0;
        for(int i=0;i<arr.length;i++) {
            totalSum+=arr[i];
        }

        int rightSum = 0;
        for(int i=arr.length-1;i>=0;i--) {
            int leftSum = totalSum - rightSum - arr[i] ;
            if(leftSum == ( rightSum)) {
                System.out.println("Equilibrium Index found at " + i);
            }
            rightSum+=arr[i];
        }

    }

    public static void main(String[] args) {
        findEquilibrium(new int[]{0, -3, 5, -4, -2, 3, 1, 0});
    }
}
