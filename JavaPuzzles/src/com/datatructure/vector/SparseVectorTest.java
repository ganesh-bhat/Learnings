package com.datatructure.vector;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SparseVectorTest {

    @Test
    public void get() {
        SparseVector sp = new SparseVector();
        sp.increment(1,25);
        sp.increment(5,10);
        sp.increment(12,10);
        sp.increment(12,15);

        Assert.assertEquals(0,sp.get(2));
        Assert.assertEquals(25,sp.get(1));
        Assert.assertEquals(25,sp.get(12));

        Assert.assertEquals(3,sp.numberNonNumZeros());

    }
    @Test
    public void dotProduct() {
        SparseVector sp = new SparseVector();
        sp.increment(1,25);
        sp.increment(5,10);
        sp.increment(12,10);

        SparseVector sp2 = new SparseVector();
        sp2.increment(5,10);


        SparseVector result = sp.dotProduct(sp2);

        Assert.assertEquals(1, result.numberNonNumZeros());
        Assert.assertEquals(100,result.get(5));


    }
}