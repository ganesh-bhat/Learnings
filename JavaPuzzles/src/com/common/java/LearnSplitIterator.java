package com.common.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * Created by ganes on 21-06-2018.
 */
public class LearnSplitIterator {

    static class TestItr implements Runnable {
        Spliterator itr;
        TestItr(Spliterator itr) {
            this.itr = itr;
        }

        @Override
        public void run() {
            itr.forEachRemaining(new Consumer() {
                @Override
                public void accept(Object o) {
                    System.out.println(o);
                }
            });
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for(int value: IntStream.range(1,100).toArray()) {
            list.add(String.valueOf(value));
        }


        Spliterator<String> spiltIterator = list.spliterator();

        Spliterator<String> itr2 = spiltIterator.trySplit();

        System.out.println("itr2 estimated size:" + itr2.estimateSize());
        System.out.println("spiltIterator estimated size:" + spiltIterator.estimateSize());

        ExecutorService executor = Executors.newFixedThreadPool(2);


        executor.submit(new TestItr(itr2), new TestItr(spiltIterator));


        try {
            executor.awaitTermination(4, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
