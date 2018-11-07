package com.algorithms.recursion;

public class RoadWithObstacles {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 0, 0, 1, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0, 1, 0, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1}
            };

        int[][] mem = new int[10][10];
        long start = System.nanoTime();
       int ways =  waysToReach(matrix,0,0,9,9, mem);
        long end = System.nanoTime();

        System.out.println("ways:"+ways);
        System.out.println((end-start));
    }

    static int waysToReach(int[][] matrix, int x1, int y1, int x2, int y2, int[][] mem) {
        if(x1==x2 &&
                y1==y2) {
            return 1;
        }

        if(x1> x2 ||
                y1>y2) {
            return 0;
        }

        if(mem[x1][y1]!=0) {
            return mem[x1][y1];
        }

        int ways = 0;
        if(x1+1 <= x2 && matrix[x1+1][y1]==1) {
            //right
            ways = waysToReach(matrix,x1+1,y1,x2,y2,mem);
        }
        if(y1+1<= y2 && matrix[x1][y1+1]==1) {
            //down
            ways+=waysToReach(matrix,x1,y1+1,x2,y2,mem);
        }

        if(x1+1 <= x2 && matrix[x1+1][y1]==1 && y1+1<= y2 && matrix[x1][y1+1]==1) {
            //diagonal
            ways+=waysToReach(matrix,x1+1,y1+1,x2,y2,mem);
        }

        mem[x1][y1] = ways;

        return  mem[x1][y1];
    }
}
