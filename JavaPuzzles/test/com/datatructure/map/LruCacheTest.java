package com.datatructure.map;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LruCacheTest {

    @Test
    public void test() {

        LruCache<String, String> cache = new LruCache<>(5);

        for(int i=0;i<10;i++) {
            cache.add(""+i,""+i);
        }

        for(int i=5;i<10;i++) {
            Assert.assertNotNull(cache.get(""+i));
        }

        for(int i=0;i<5;i++) {
            Assert.assertNull(cache.get(""+i));
        }

    }
}