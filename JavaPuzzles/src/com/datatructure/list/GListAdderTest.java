package com.datatructure.list;

import com.datatructure.list.GLinkedList;
import com.datatructure.list.GListAdder;
import org.junit.Test;

public class GListAdderTest {

    @Test
    public void testAdd() {
        GListAdder adder = new GListAdder();

        for(Long l: getList(617)) {
            System.out.println(l);
        }

        GLinkedList<Long> result =  adder.add(getListRev(61702), getListRev(295));

        System.out.println(result);
    }

    @Test
    public void testAddRec() {
        GListAdder adder = new GListAdder();

        GLinkedList<Long> result =  adder.addRec(getList(61782), getList(295));

        System.out.println(result);
    }

    private GLinkedList<Long> getListRev(long i) {
        GLinkedList<Long> list = new GLinkedList<>();

        long divider = 10;

        long num = i;
        long reminder = 0;
        while(num > 0) {
            reminder = num % divider;
            num = num / divider;
            list.insertAtEnd(reminder);
        }

        return list;
    }

    private GLinkedList<Long> getList(long i) {
        GLinkedList<Long> list = new GLinkedList<>();

        long divider = 10;

        long num = i;
        long reminder = 0;
        while(num > 0) {
            reminder = num % divider;
            num = num / divider;
            list.insertAtStart(reminder);
        }

        return list;
    }


}
