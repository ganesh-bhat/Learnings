package com.datatructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllBst {

    static class Node<T extends Comparable>{
        Node<T> left;
        Node<T> right;
        T data;

        Node(T num) {
            this.data = num;
        }

    }

    public static Node createBinaryTree(List<Integer> list) {
        Node root = addNode(null,list.get(0));
        for(int i=1;i<list.size();i++) {
            addNode(root,list.get(i));
        }
        return root;
    }

    private static<T  extends Comparable> Node addNode(Node root, T num) {
        if(num == null ) return null;
        if(root == null ) return new Node(num);

        if(num.compareTo(root.data)<0) {
            if(root.left == null ){
                root.left = new Node(num);
            } else {
                addNode(root.left, num);
            }

        } else {
            if(root.right == null ){
                root.right = new Node(num);
            } else {
                addNode(root.right, num);
            }

        }
        return null;
    }


    public static void main(String[] args) {
        Node node = createBinaryTree(Arrays.asList(1,2,3));

        permutations(Arrays.asList(1,2,3), 3);


    }

    private static void permutations(List<Integer> nums, int n) {
        if(n == 1) {
            System.out.println(nums);
            return;
        }

        for(int i=0;i<n;i++) {
            Collections.swap(nums,i,n-1);
            permutations(new ArrayList<>(nums),n-1);
            Collections.swap(nums,i,n-1);
        }
    }



}
