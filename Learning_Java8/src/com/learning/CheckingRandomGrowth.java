package com.learning;

import java.util.concurrent.ThreadLocalRandom;

public class CheckingRandomGrowth {

    public static void main(String[] args) {

        double delay = 5;
        for(int i=0;i<50;i++) {
            delay = delay * 2 * (0.9 + ThreadLocalRandom.current().nextDouble() * 0.2);
            System.out.println((long)delay);
        }
    }
}
