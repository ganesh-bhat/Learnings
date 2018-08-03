package com.datatructure.list;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReverseKNodesTest {

    @Test
    public void test() {
        ReverseKNodes reverseKNodes = new ReverseKNodes(Arrays.asList(1,2,3,4,5,6));
        reverseKNodes.print();
        reverseKNodes.reverseNodes(3);
        reverseKNodes.print();

    }

}