package com.datatructure.tree;

import sun.reflect.generics.tree.Tree;

public class TreeChildrenSum {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    TreeNode root;

    public void insert(int data) {
        if(root == null) {
            root = new TreeNode(data);
        } else {
            TreeNode current  = root;
            while(current!=null) {
                if(current.data >= data) {
                    if(current.right == null) {
                        current.right = new TreeNode(data);
                    } else {
                        current = current.right;
                    }
                } else {
                    if(current.left == null) {
                        current.left = new TreeNode(data);
                    } else {
                        current = current.left;
                    }
                }
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, root);
        return sb.toString();
    }

    private void toString(StringBuilder sb, TreeNode current) {
        if(current == null) return;

        sb.append(current.data);
        sb.append(" ");

        toString(sb, current.left);
        toString(sb, current.right);
    }

    public static void main(String[] args) {
        TreeChildrenSum tree = new TreeChildrenSum();
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(4);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(9);
        tree.root.left.right.left = new TreeNode(3);
        tree.root.right = new TreeNode(1);
        tree.root.right.right = new TreeNode(2);

        System.out.println(tree.toString());
        tree.computeSum(tree.root);
        System.out.println(tree.toString());

    }

    int computeSum(TreeNode node) {
        if(node == null) return 0;
        int sum = node.data+computeSum(node.left)+ computeSum(node.right);
        node.data = sum;
        return sum;
    }

}
