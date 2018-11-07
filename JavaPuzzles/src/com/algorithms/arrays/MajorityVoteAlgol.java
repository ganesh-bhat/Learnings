package com.algorithms.arrays;

public class MajorityVoteAlgol {

    private static void findMajority(int[] arr){

        int i=0;
        int m = 0;
        for(int x:arr) {
            if( i == 0) {
                m = x;
                i=1;
            } else if(m == x) {
                i++;
            } else {
                i--;
            }
        }

        if( i > 1) {
            System.out.println("majority:"+m);
        } else {
            System.out.println("No majority");
        }


    }

    public static void main(String[] args) {
        findMajority(new int[] {1,2,3,2,2,2,2,5,2,6,2});
        findMajority(new int[] {1,6,3,3,1,12,32,45,12,6,62});
    }

}
