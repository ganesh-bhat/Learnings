package com.algorithms.arrays;

import java.util.regex.Pattern;

public class RepeatedSubstring {


    public static void main(String[] args) {
        String str = "axaaxa";
        findRepeatingSubString(str);
        findRepeatingSubStringRedEx(str);
    }

    private static void findRepeatingSubStringRedEx(String str) {
        boolean found = true;
        String subStr = null;
        for (int i = 1; i < str.length(); i++) {
            subStr = str.substring(0, i);
            if (str.length() % subStr.length() != 0) continue;
            Pattern pattern = Pattern.compile("("+subStr+")+");
            if(pattern.matcher(str).matches()) {
                found = true;
                break;
            }

        }

        if (found && str.length()>0) {
            System.out.println("Found substring:" + subStr);
        } else {
            System.out.println("Not found");
        }

    }

    private static void findRepeatingSubString(String str) {
        boolean found = true;
        String subStr = null;
        for (int i = 1; i < str.length(); i++) {
            subStr = str.substring(0, i);
            if (str.length() % subStr.length() != 0) continue;

            int k = 0;
            found = true;
            for (int j = 0; j < str.length(); j++) {
                if (subStr.charAt(k) != str.charAt(j)) {
                    found = false;
                    break;
                }
                k = (k + 1) % i;
            }
            if (found) {
                break;
            }
        }

        if (found && str.length()>0) {
            System.out.println("Found substring:" + subStr);
        } else {
            System.out.println("Not found");
        }
    }

    private static void findRepeatingSubStringBest(String str) {
        int[] freq = new int[256];
        //populate frequency
        for(int i=0;i< str.length();i++) {
            freq[str.charAt(i)]+=1;
        }

        //gcd of frequencies





    }
}
