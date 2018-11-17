package com.fire_drill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DuplicateFinder {

    public List<Integer> findDuplicates(List<Integer> numbers) {
        List<Integer> duplicates = new ArrayList<>();
        Collections.sort(numbers);
        for(int i=0;i<numbers.size()-1;i++) {
            if(numbers.get(i).equals(numbers.get(i+1))) {
                //found duplicate
                if(duplicates.isEmpty() || !(duplicates.get(duplicates.size()-1).equals(numbers.get(i)))){
                    //already not in duplicated numbers
                    duplicates.add(numbers.get(i));
                }
            }

        }
        return duplicates;
    }

    public static void main(String[] args){
        DuplicateFinder duplicateFinder = new DuplicateFinder();
        List<Integer> duplicates = duplicateFinder.findDuplicates(Arrays.asList(1,2,3,2,4,1,6,7,3,9,4,4,6,2));
        System.out.println(duplicates);
    }
}
