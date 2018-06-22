package com.features;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ganes on 10-06-2018.
 */
public class SuperUses extends ArrayList {

    public static void main(String[] args) {

    }


    SuperUses() {
        //super constructor
        super();

    }
    private void test() {
        //method
        super.clear();
        //variable
        System.out.println(super.modCount);
        List<? super Integer> list;

    }


}
