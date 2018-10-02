package com.algorithms.recursion;

import java.util.Arrays;

/**
 * one string can be converted to another by inserting a char, updating or deleting a char
 * Ex: SATURDAY -> SUNDAY 9 insert AT , replace N to R , 3 is the answer
 */
public class FindMinEditDistace {


    private static int findEditDistance(String src, String dest, int srcPos, int destPos) {
        if(src.substring(srcPos).isEmpty()) return dest.substring(destPos).length();
        if(dest.substring(destPos).isEmpty()) return src.substring(srcPos).length();

        if (src.charAt(srcPos) == dest.charAt(destPos)) {
            return findEditDistance(src, dest, srcPos+1, destPos+1);
        } else {
            int d = findEditDistance(src, dest, srcPos+1, destPos);
            int i = findEditDistance(src, dest, srcPos, destPos+1);
            int u = findEditDistance(src, dest, srcPos+1, destPos+1);
            return min(d,u,i)+1;
        }
    }

    private static int min(int x, int y, int z ) {
        return x <y? ( x<z ? x: z) : ( y<z?y:z);
    }

    /* with memoization - NOT WORKINNG!! need to check*/
    private static int[][] memo;
    private static int findEditDistanceMemo(String src, String dest) {
        memo = new int[src.length()][dest.length()];
        for(int i=0;i<memo.length;i++) {
            Arrays.fill(memo[i],-1);
        }

        return findEditDistanceMemo(src, dest, 0, 0 );

    }

    private static int findEditDistanceMemo(String src, String dest, int srcPos, int destPos) {
        if(memo[srcPos][destPos]!=-1) {
            return memo[srcPos][destPos];
        }

        if(src.substring(srcPos).isEmpty())  {
            memo[srcPos][destPos] = dest.substring(destPos).length();
            return memo[srcPos][destPos];
        }
        if(dest.substring(destPos).isEmpty()) {
           memo[srcPos][destPos] =  src.substring(srcPos).length();
            return memo[srcPos][destPos];
        }

        if (src.charAt(srcPos) == dest.charAt(destPos)) {
            memo[srcPos][destPos] = findEditDistance(src, dest, srcPos+1, destPos+1);
            return memo[srcPos][destPos];
        } else {
            int d = findEditDistance(src, dest, srcPos+1, destPos);
            int i = findEditDistance(src, dest, srcPos, destPos+1);
            int u = findEditDistance(src, dest, srcPos+1, destPos+1);
            memo[srcPos][destPos] =  min(d,u,i)+1;
            return memo[srcPos][destPos];
        }
    }


    public static void main(String[] args) {

        System.out.println(findEditDistanceMemo("SUNDAY", "SATURDAY"));

        //findEditDistance("SUNDAY", "SATURDAY",0,0);

    }

}
