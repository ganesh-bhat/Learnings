package com.puzzles;

public class ConseqSum {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 4,5,6,8,11,15,18,20};
        int reqSum = 45;

        int sum =0;
        int start = 0;
        int end = 0;

        for(int i=0;i<numbers.length;i++) {
            sum+=numbers[i];
            end = i;

            if(end - start > 4) {
                //move the start
                sum = sum - numbers[start];
                start++;//move the start
            }

            if(sum==reqSum) {
                break;
            } else if(sum>reqSum) {
                break;
            }
        }

        if(reqSum == sum) {
            for(int j=start;j<=end;j++) {
                System.out.print(numbers[j]+" ");
            }
        } else {
            System.out.println("-1");
        }

    }
}
