package com.datatructure.vector;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void push() {

        Vector<String> vector = new Vector<>();
        vector.push("A");
        vector.push("B");
        vector.push("C");

        Assert.assertEquals("C", vector.pop());
        Assert.assertEquals("B", vector.pop());
        Assert.assertEquals("A", vector.pop());
    }

    @Test
    public void insert() {
        Vector<String> vector = new Vector<>();
        vector.insert(1, "C");
        vector.insert(3, "D");
        vector.insert(18, "B");

        Assert.assertEquals("C", vector.at(1));
        Assert.assertEquals("B", vector.at(18));
        Assert.assertEquals("D", vector.at(3));
    }

    @Test
    public void prepend() {
        Vector<String> vector = new Vector<>();
        vector.prepend("A");
        vector.prepend("B");
        vector.prepend("C");

        Assert.assertEquals("A", vector.pop());
        Assert.assertEquals("B", vector.pop());
        Assert.assertEquals("C", vector.pop());

    }

    @Test
    public void delete() {
    }

    @Test
    public void find() {
        Vector<String> vector = new Vector<>();
        vector.prepend("A");
        vector.prepend("B");
        vector.prepend("C");

        Assert.assertTrue(vector.find("B"));
        Assert.assertFalse(vector.find("E"));

    }

    @Test
    public void remove() {
        Vector<String> vector = new Vector<>();
        vector.prepend("A");
        vector.prepend("B");
        vector.prepend("C");

        Assert.assertTrue(vector.remove("B"));
        Assert.assertFalse(vector.remove("E"));
    }

}