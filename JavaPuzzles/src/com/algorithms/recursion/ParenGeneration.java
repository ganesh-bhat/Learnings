package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class ParenGeneration {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        paren(result,"",n,n,0);
        return result;
    }

    private static void paren(List<String> result, String solution, int countOpen, int countClose, int effectiveOpen) {
        if(countOpen == 0 && countClose == 0) {
            if(effectiveOpen == 0) {
                //effective
                result.add(solution);
            }
            return;
        } else if(effectiveOpen>0 && countClose == 0) {
            return;
        }

        if(countOpen >0) {
            paren(result, solution+"(", countOpen-1, countClose, effectiveOpen+1);
        }

        if(countClose>0 && countOpen < countClose) {
            paren(result, solution+")", countOpen, countClose-1, effectiveOpen-1);
        }
    }
}
