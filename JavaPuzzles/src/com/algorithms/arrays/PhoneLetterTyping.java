package com.algorithms.arrays;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class PhoneLetterTyping {




    public static List<String> letterCombinations(String digits) {

        if(digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }

       String[] legend = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        List<String> result = new ArrayList<>();

        permute(result,legend, "",0,digits);

        return new ArrayList<>(result);
    }

    private static void permute(List<String> result, String[] legend, String permutation, int pos, String digits) {
        if(pos >= digits.length()) {
            result.add(permutation);
            return;
        }
        String str = legend[digits.charAt(pos)-'0'];
        for(char c:str.toCharArray()) {
            permute(result,legend, permutation+c, pos+1,digits);
        }
    }
}
