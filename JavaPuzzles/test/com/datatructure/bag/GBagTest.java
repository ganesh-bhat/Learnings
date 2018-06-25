package com.datatructure.bag;

import com.datatructure.bag.GBag;
import org.junit.Test;

import java.util.Iterator;
import java.util.stream.IntStream;

public class GBagTest {

    @Test
    public void test() {
        GBag<Integer> bag = new GBag<>(3);

        for(int x: IntStream.range(2,55).toArray()) {
            bag.add(x);
        }

        for(Iterator<Integer> itt = bag.iterator(); itt.hasNext();) {
            System.out.println(itt.next());
        }
    }
}
