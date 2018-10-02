package com.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * SLIDING WINDOW - https://gist.github.com/wayetan/8265857
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {

    }

    private static int longestSubstring(String str) {
        int i =0;
        int j=0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while(i<str.length()) {

            if(!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                j++;
                max = Math.max(max, set.size());

            } else {
                set.remove(str.charAt(i++));
            }

        }


        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++) {
            while(exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }



}
