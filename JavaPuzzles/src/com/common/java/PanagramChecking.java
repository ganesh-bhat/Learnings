package com.common.java;

public class PanagramChecking {

    private static boolean isPanagram(String str) {

        int flag = ~~(0);


        char c;
        int pos = 0;
        for(int i=0;i<str.length();i++) {
            c = str.charAt(i);
            if(c-'a' < 0) {//uppercase
                pos = c-'A';
                flag = flag | (1<<pos);
            } else { //lowercase
                pos = c-'a';
                flag = flag | (1<<pos);
            }
        }

        System.out.println(Integer.toBinaryString(( ((1<<27) -1))));
        return ((flag & ((1<<26) -1)) == ((1<<27) -1));

    }

    public static void main(String[] args) {
        System.out.println(isPanagram("The quick brown fox jumps over the lazy dog"));

        //System.out.println(Integer.toBinaryString(((1<<27) -1)  & (1<<26 | 1<<23)));
    }
}
