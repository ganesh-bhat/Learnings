package com.algorithms.permutationCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationGenerator {

    public static<T> List<List<T>> permutations(List<T> elements) {
        List<List<T>> result = new ArrayList<>();
        permute(result,elements,0,elements.size()-1);
        return result;
    }


    private static<T> void permute(List<List<T>> result, List<T> elements, int left, int right) {
        if(left == right)
            result.add(elements);

        for(int i=left;i<=right;i++) {
            List<T> list = new ArrayList<>(elements);
            swap(list,left,i);
            permute(result,list,left+1,right);
            list = new ArrayList<>(elements);
            swap(list,left,i);
        }
    }


    private static<T> void swap(List<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }


    public static void main(String[] args) {
        List<List<Integer>> result = permutations(Arrays.asList(1, 2, 3));

        System.out.println(result);
    }

}
