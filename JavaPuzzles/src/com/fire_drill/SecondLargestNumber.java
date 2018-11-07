package com.fire_drill;

public class SecondLargestNumber {
    public int findSecondLargest(int[] input) {
        if(input == null || input.length == 0 ) return Integer.MIN_VALUE;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i=0;i<input.length;i++){
            if(input[i] > first ) {
                second = first;
                first = input[i];
            } else if(input[i]>second && input[i] != first) {
                second = input[i];
            }
        }

        return second;
    }


    public static void main(String[] args){
        SecondLargestNumber secondLargestFinder = new SecondLargestNumber();
        //expect 15
        int max2 = secondLargestFinder.findSecondLargest(new int[]{7,8,9,18,12,13,15,21,20});
        System.out.println("2nd largest is:"+max2);
    }


}
