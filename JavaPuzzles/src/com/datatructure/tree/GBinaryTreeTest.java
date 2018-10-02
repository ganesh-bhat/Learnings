package com.datatructure.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class GBinaryTreeTest {

    @Test
    public void test() {

        GBinaryTree<Integer> tree = new GBinaryTree<>(new Integer[]{15,8,18,6,12,16,19,3,7,2,4,5});

        tree.traverse(t -> System.out.println(t));

        System.out.println(tree.checkBalanced());

    }




}