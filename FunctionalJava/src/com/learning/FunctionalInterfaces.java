package com.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class FunctionalInterfaces {

    private static BinaryOperator<Long> adder = (a,b) -> a+b;
    private static Consumer<Integer> consumer = it ->  System.out.println(it);
    private static Function<String[], List> function = (s) -> Arrays.asList(s);
    private static Supplier<Double> randomNumFactory  = () -> Math.random();


    public static void main(String[] args) {
        Long result = adder.apply(3L,5L);
        System.out.println(result);
        consumer.accept(5);

        //calling random factory
        for(int i : IntStream.range(1,14).toArray()) {
            System.out.println(randomNumFactory.get());
        }


    }


}
