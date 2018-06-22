package com.datatructure;

import java.util.Iterator;

public class GListAdder {

    public GLinkedList<Long> add(GLinkedList<Long> num1, GLinkedList<Long> num2) {
        System.out.println(num1);
        System.out.println(num2);

        GLinkedList<Long> sum = new GLinkedList<>();

        Iterator<Long> itt1 = num1.iterator();
        Iterator<Long> itt2 = num2.iterator();

        long reminder;
        long carry = 0;
        while(itt1.hasNext() || itt2.hasNext()) {
            long n1 = 0;
            if(itt1.hasNext()) {
                n1 = itt1.next();
            }
            long n2 = 0;
            if(itt2.hasNext()) {
                n2 = itt2.next();
            }
            long s = n1+n2 + carry;

            reminder = s %10;
            carry = s/10;
            sum.insertAtEnd(reminder);
        }

        if(carry!=0) {
            sum.insertAtEnd(carry);
        }

        return sum;
    }

    public GLinkedList<Long> addRec(GLinkedList<Long> num1, GLinkedList<Long> num2) {
        if(num1.size()!=num2.size()) {
            System.out.println(num1.size());
            System.out.println(num2.size());
             int maxSize = num1.size() > num2.size()? num1.size() : num2.size();
             GLinkedList<Long> smallList = num1.size() > num2.size()? num2 : num1;
             int zerosToPadd = maxSize - smallList.size();

             for(int i=0;i<zerosToPadd;i++) {
                 smallList.insertAtStart(0L);
             }
        }

        System.out.println(num1);
        System.out.println(num2);

        GLinkedList<Long> sum = new GLinkedList<>();
        
        Iterator<Long> itt1 = num1.iterator();
        Iterator<Long> itt2 = num2.iterator();

        long carry = internalAddRec(itt1,itt2,sum);
        if(carry!=0) {
            sum.insertAtStart(carry);
        }

        return sum;
    }

    private long internalAddRec(Iterator<Long> itt1, Iterator<Long> itt2, GLinkedList<Long> sum) {
        if(itt1.hasNext() && itt2.hasNext()) {
            long n1 = itt1.next();
            long n2 = itt2.next();
            long carry = internalAddRec(itt1,itt2,sum);
            long s = n1+n2+carry;
            long reminder = s %10;
            carry = s/10;
            sum.insertAtStart(reminder);
            return carry;
        }
        return 0;
    }

}
