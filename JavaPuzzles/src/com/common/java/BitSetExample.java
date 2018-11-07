package com.common.java;

import java.util.BitSet;

public class BitSetExample {

    public static void main(String[] args) {

        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();

        bitSet1.set(2);
        bitSet1.set(4);

        int num = 0b11_001;
        System.out.println(num);
        BitSet bs = convert(25L);
        System.out.println(bs);
        System.out.println(convert(bs));

        System.out.println(BitSet.valueOf(new long[]{25}));
        System.out.println(bs.toLongArray()[0]);

        System.out.println(BitSet.valueOf(new long[]{-25}).toLongArray()[0]);


    }

    /*
        long to bitSet
     */

    public static BitSet convert(long value) {

        BitSet bitSet = new BitSet();
        int count = 0;
        while (value != 0L) {
            if (value % 2L != 0L) {
                bitSet.set(count);
            }

            value = value >>> 1;
            count++;
        }

        return bitSet;
    }

    public static long convert(BitSet bitSet) {
        long value = 0L;
        for (int i = 0; i < bitSet.length(); i++) {
            value += bitSet.get(i) ? (1L << i) : 0;
        }
        return value;
    }
}