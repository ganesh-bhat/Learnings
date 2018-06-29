package com.datatructure.map;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GMap2Test {

    @Test
    public void put() {

        GMap2<Integer,String> map = new GMap2<>();
        for(int i=0;i<15;i++) {
            map.put(i,""+i);
        }

        for(int i=0;i<15;i++) {
            String val = map.get(i);
            Assert.assertEquals(""+i,val );
            System.out.println(val);
        }
    }

    @Test
    public void get() {
    }
}