package com.algorithms.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestPalindromeSubString {

    public static String bruteForce(String str) {
        int j = str.length()-1;
        int k = 0;

        int start = -1;
        int end = -1;
        boolean foundPali = true;
        for(int i=0;i<str.length();i++) {
            start = k = i;
            end = j = str.length()-1;
            while(k<j) {
                if(str.charAt(k) == str.charAt(j)) {
                    k++;
                    foundPali = true;
                } else {
                    foundPali = false;
                }
                j--;
            }
            if(foundPali && (j == k|| j<k)) {
                System.out.println("Found start:"+start+",end:"+end);
                break;
            }
        }
        return str.substring(start, end+1);
    }

    public static String optimum(String str) {
        Map<Character,List<Integer>> map = new HashMap<>();
        for(int i=0;i<str.length();i++) {
            if(!map.containsKey(str.charAt(i))){
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(str.charAt(i), list);
            } else {
                List<Integer> list = map.get(str.charAt(i));
                list.add(i);
            }
        }

        int k =0;
        int start = 0;
        int end = 0;
        for(int j=0;j<str.length();j++) {
            if(map.get(str.charAt(j))!=null) {
                List<Integer> list = map.get(str.charAt(j));
                k = list.remove(list.size()-1);
                if(k == j) {
                    continue;
                }

                start = j;
                end = k;

                while(j<k && str.charAt(++j) == str.charAt(--k)){
                    //continue till it exhausts
                }
                if(j >= k && start>=0 && end>=0) {
                    return str.substring(start,end+1);
                }
            } else {
                continue;
            }
        }
        return str.substring(0,1);

    }



    public static String dynamicProgramming(String str) {
        int start = 0;
        int end = 0;
        for(int i=0;i<str.length();i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1)/2;
                end = i + (len)/2;
            }
        }

        return str.substring(start,end+1);
    }

    private static int expandAroundCenter(String str, int left, int right) {

        while(left>=0 && right <str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right -left -1;
    }


}
