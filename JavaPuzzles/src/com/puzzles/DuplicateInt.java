package com.puzzles;

public class DuplicateInt {

    public static void main(String[] args) {

        int[] V = new int[]{1,3,4,5,3,6,7,8,9,10,2};

        int slow = 0;
        int fast = 0;

        do {
            slow = V[slow];
            fast = V[V[fast]];
            System.out.println("slow:"+slow+",fast:"+fast);
        } while(slow!=fast);

        System.out.println("ended!");

        int slow2 = 0;
        do {
            slow = V[slow];
            slow2 = V[slow2];
            System.out.println("slow:"+slow+",slow2:"+slow2);
        } while(slow!=slow2);



    }
}
