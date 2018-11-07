package com.puzzles;

import java.util.Arrays;

/**
 * You have written an anonymous love letter and you don&rsquo;t want your handwriting to be recognized.
 * Since you don&rsquo;t have a printer within reach, you are trying to write this letter by copying and pasting
 * characters from a newspaper.
 * <p>
 * Given a string L representing the letter and a string N representing the newspaper, return true if the L can be
 * written entirely from N and false otherwise. The letter includes only ascii characters.
 */
public class AnonymousLoveLetter {


    public boolean canWrite(String newsPaper, String letter) {
        if (letter.isEmpty()) return true;
        if (newsPaper.isEmpty()) return false;

        int[] chars = new int[256];
        Arrays.fill(chars, 0);

        for (int i = 0; i < newsPaper.length(); i++) {
            chars[newsPaper.charAt(i)]++;
        }

        for (int i = 0; i < letter.length(); i++) {
            if (chars[letter.charAt(i)] <= 0) {
                return false;
            } else {
                chars[letter.charAt(i)]--;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        AnonymousLoveLetter anonymousLoveLetter = new AnonymousLoveLetter();
        System.out.println(anonymousLoveLetter.canWrite("hello", "hel"));
        System.out.println(anonymousLoveLetter.canWrite("hello", "hell"));
        System.out.println(anonymousLoveLetter.canWrite("hello", "hello"));
        System.out.println(anonymousLoveLetter.canWrite("hello", "helloo"));

    }

}