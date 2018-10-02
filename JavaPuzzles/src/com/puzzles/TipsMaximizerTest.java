package com.puzzles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TipsMaximizerTest {

    @Test
    public void maximizeTips() {
        TipsMaximizer.maximizeTips(sampleSet1());
        System.out.println("------------");
        TipsMaximizer.maximizeTips(sampleSet2());
    }

    private List<TipsMaximizer.Waiter> sampleSet1() {
        TipsMaximizer.Waiter waiter = new TipsMaximizer.Waiter("A", 3);
        waiter.setTips(tipsList(1,2,3,4,5));

        TipsMaximizer.Waiter waiter2 = new TipsMaximizer.Waiter("B", 3);
        waiter2.setTips(tipsList(5,4,3,2,1));
        return Arrays.asList(waiter, waiter2);
    }

    private List<TipsMaximizer.Waiter> sampleSet2() {
        TipsMaximizer.Waiter waiter = new TipsMaximizer.Waiter("A", 4);
        waiter.setTips(tipsList(1, 4, 3, 2, 7, 5, 9, 6 ));

        TipsMaximizer.Waiter waiter2 = new TipsMaximizer.Waiter("B", 4);
        waiter2.setTips(tipsList(1, 2 ,3 ,6, 5, 4 ,9, 8));


        return Arrays.asList(waiter, waiter2);
    }

    private List<TipsMaximizer.Tip> tipsList(long... tips) {
        List<TipsMaximizer.Tip> list = new ArrayList();
        for(int i=0;i<tips.length;i++) {
            list.add(new TipsMaximizer.Tip(i, tips[i]));
        }
        return list;
    }
}