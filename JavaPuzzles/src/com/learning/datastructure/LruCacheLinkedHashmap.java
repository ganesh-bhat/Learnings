package com.learning.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ganes on 20-06-2018.
 */
public class LruCacheLinkedHashmap {

    public static void main(String[] args) {
        MyLru myLru = new MyLru(5);

        for(int i=5;i<10;i++) {
            myLru.put(i,""+i);
        }

        myLru.get(5);
        myLru.get(6);

        myLru.put(11,""+11);
        myLru.put(12,""+12);


        System.out.println(myLru);

        long f = 0x7ffbfeffafffcfdfL;
        System.out.println(String.format("%,d",f));
        System.out.println(Long.toBinaryString(f));
        System.out.println(Long.toBinaryString((f >>> 32)));
        System.out.println(Long.toBinaryString(f^(f >>> 32)));

        System.out.println(((int)(f ^ (f >>> 32))));

    }

    /* easy java way */
    static class MyLru extends LinkedHashMap {

        int capacity;

        public MyLru(int capacity){
            super(capacity,0.75f,true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            if(size()>capacity) {
                return true;
            }
            return false;
        }
    }


}
