package com.algorithms.trees;

import java.util.Arrays;

public class TreeClient {

    public static void main(String[] args) {

        Tree<Integer> tree = new LinkedBinaryTree();

        Tree.TreeNode node2 = tree.newNode(7);
        node2.setChildren(Arrays.asList(tree.newNode(6)));

        Tree.TreeNode node3 = tree.newNode(9);
        node3.setChildren(Arrays.asList(tree.newNode(11)));

        Tree.TreeNode node = tree.newNode(8);
        node.setChildren(Arrays.asList(node2,tree.newNode(9)));






        tree.setRoot(node);



    }
}
