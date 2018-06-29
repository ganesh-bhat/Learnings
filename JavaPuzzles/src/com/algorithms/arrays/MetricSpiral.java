package com.algorithms.arrays;

public class MetricSpiral {


    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}

        };


        boolean flag = true;
        int j=0;
        for(int i=0;i<matrix.length;i++) {
            if(flag) {
                j = 0;
            } else {
                j = matrix[0].length-1;
            }

            while(j<matrix[0].length && j>=0) {
                System.out.print(matrix[i][j]+" ");
                if(flag) {
                    j++;
                } else {
                    j--;
                }
            }
            flag=!flag;
            System.out.println();
        }


    }
}
