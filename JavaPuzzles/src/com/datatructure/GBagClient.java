package com.datatructure;

import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * Created by ganes on 21-06-2018.
 */
public class GBagClient {

    public static void main(String[] args) {
        GBag<Integer> bag = new GBag<>(3);

        for(int x: IntStream.range(2,55).toArray()) {
            bag.add(x);
        }

        for(Iterator<Integer> itt = bag.iterator();itt.hasNext();) {
            System.out.println(itt.next());
        }
    }
}
