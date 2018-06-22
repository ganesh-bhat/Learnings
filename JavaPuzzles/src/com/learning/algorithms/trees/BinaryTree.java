package com.learning.algorithms.trees;

/**
 * Created by ganes on 09-06-2018.
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node<Integer>(8);
        tree.root.left = new Node<Integer>(6);
        tree.root.right = new Node<Integer>(9);
        tree.root.left.left = new Node<Integer>(4);
        tree.root.right.left = new Node<Integer>(3);
        tree.root.right.right = new Node<Integer>(11);

        System.out.println(minDepth(tree.root));
    }

   static class Node<T> {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }
    }

    Node root;

    private static int minDepth(Node node) {

        if(node == null) {
            return 0;
        }

        if(node.left == null && node.right == null) {
            return 1;
        }
        if(node.left == null) {
            return 1 + minDepth(node.right);
        }

        if(node.right == null) {
            return 1 + minDepth(node.left);
        }

        return Math.min(minDepth(node.left),minDepth(node.right)) + 1;

    }




}
