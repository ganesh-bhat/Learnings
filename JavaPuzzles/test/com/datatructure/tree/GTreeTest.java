package com.datatructure.tree;

import org.junit.Test;

public class GTreeTest {

    @Test
    public void getRoot() {
    }

    @Test
    public void setRoot() {
    }

    @Test
    public void test() {

        GNAryTree<Integer> tree = new GNAryTree.TreeBuilder()
                .addNode(5)
                .addNode(6)
                .addNode(new GNAryTree.TreeBuilder()
                        .addNode(7)
                        .addNode(8)
                        .addNode(new GNAryTree.TreeBuilder()
                                .addNode(9)
                                .addNode(10)
                                .addNode(11)
                                .toTree())
                        .toTree()
                ).toTree();

        tree.traverseDfs(num -> System.out.println(num));
    }
}