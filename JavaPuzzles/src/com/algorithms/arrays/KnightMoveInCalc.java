package com.algorithms.arrays;

/**
 *  |1,2,3|
 *  |4,5,6|
 *  |7,8,9|
 *  |0|
 */
public class KnightMoveInCalc{

    private static void find(int num) {
        if(num<0) return;
        int x = num%3-1;
        int y = num/3;
        if(num == 0) {
            x = 4;
            y = 0;
        }


        int[] dxs = {1,2,-1,-2};
        int[] dys = {1,2,-1,-2};
        for(int dx:dxs) {
            for(int dy:dys) {
                if(Math.abs(dx)!=Math.abs(dy)) {
                    if((x+dx)>=0 && (x+dx)<3 &&
                            (y+dy)>=0 && (y+dy)<3) {
                        System.out.println((y+dy)*3+(x+dx)+1);
                    } else if((y+dy)==3 && (x+dx)==0) {
                        System.out.println("0");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        find(5);
    }
}

