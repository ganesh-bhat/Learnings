package com.algorithms.recursion;

public class TowerOfHonai {

    public static void main(String[] args) {
        System.out.println("hello world");

        move(3,'s','d','e');
    }


    private static void move(int n,char source, char dest, char axe ) {
        if(n<0)  {
            return;
        }

        if(n==1)  {
            System.out.println("moving disk "+n+" from "+source+" to "+dest);
            return;
        }
        move(n-1,source, axe, dest);
        System.out.println("moving disk "+n+" from "+source+" to "+dest);
        move(n-1,axe, dest, source);
    }
}
