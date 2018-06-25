package com.datatructure.tree;

import java.util.function.Consumer;

public class GBinaryTree<T extends Comparable> {

    private Node<T> root;

    public GBinaryTree(Node<T> root) {
        this.root = root;
    }

    public GBinaryTree(T[] array) {
        buildFromArray(array);
    }

    private void buildFromArray(T[] array) {
        for(int i=0;i<array.length;i++) {
            if(root == null) {
                root = new Node<T>(array[i]);
            } else {
                Node<T> node = new Node<T>(array[i]);
                Node<T> current = root;
                while(true) {
                    if(node.data.compareTo(current.data)>0) {
                        if(current.right == null) {
                            current.right = node;
                            break;
                        }
                        current = current.right;
                    }

                    if(node.data.compareTo(current.data)<0) {
                        if(current.left == null) {
                            current.left = node;
                            break;
                        }
                        current = current.left;
                    }
                }
            }
        }
    }

    public void traverse(Consumer<T> consumer) {
        inOrder(root, consumer);
    }

    private void inOrder(Node<T> node, Consumer<T> consumer) {
        if(node == null) return;
        inOrder(node.left, consumer);
        consumer.accept(node.data);
        inOrder(node.right, consumer);
    }


    public boolean checkBalanced() {
        return checkBalanced(root);
    }

    private boolean checkBalanced(Node<T> node) {
        if(node == null) {
            return true;
        }

        int heightDiff = Math.abs(getHeight(node.left) - getHeight(node.right));
        System.out.println("heightDiff:"+heightDiff+", at node:"+node.data);
        if( heightDiff > 1) {
            return false;
        } else {
            return checkBalanced(node.left) && checkBalanced(node.right);
        }

    }


    private int getHeight(Node<T> node) {
        if(node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right)) + 1;
    }



    public static class Node<T> {
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

}
