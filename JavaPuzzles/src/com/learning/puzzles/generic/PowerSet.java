package com.learning.puzzles.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ganes on 21-06-2018.
 */
public class PowerSet<E> {

    Set<Set<E>> powerSet;

    public PowerSet(Set<E> elems) {
        powerSet = new HashSet<>();
        generatePowerSet(elems);
    }

    private void generatePowerSet(Set<E> elems) {
        List<E> setInList = new ArrayList<E>(elems);
        int powerSetSize = (int)Math.pow(2, elems.size());
        for(int i=0; i<powerSetSize; i++) {
            Set<E> subSet = new HashSet<>(elems.size());
            for(int j=0;j<powerSet.size();j++) {
                if((i & (1<<j))>0){
                    subSet.add(setInList.get(j));
                }
            }
            powerSet.add(subSet);
        }
    }

    public Set<Set<E>> get() {
        return powerSet;
    }


    public static void main(String[] args) {
        Set<Character> set = new HashSet<>(4);
        set.add('a');
        set.add('b');
        set.add('c');
        System.out.println(new PowerSet<Character>(set).get());

    }


}
