package com.datatructure.tree;


public class CountNodesInRange {

    static class TreeNode<T extends Comparable<T>>{
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }

    public static<T extends Comparable<T>> int countNodesInRange(TreeNode<T> root, T start, T end) {
        if(root == null) {
            return 0;
        }



        if(root.data.compareTo(start)<0) {
            return countNodesInRange(root.right,start,end);
        } else if(root.data.compareTo(start)>= 0 && root.data.compareTo(end)<0) {
            return 1+countNodesInRange(root.left,start,end) + countNodesInRange(root.right,start,end);
        } else {
            return countNodesInRange(root.left,start,end);
        }
    }


    public static<T extends Comparable<T>> int countNodesInRange2(TreeNode<T> root, T start, T end) {
        if(root == null) {
            return 0;
        }
        return countNodesInRange2(root.left,start,end) + countNodesInRange2(root.right,start,end) +
                ((root.data.compareTo(start)>= 0 && root.data.compareTo(end)<0)? 1:0);

    }

    public static<T extends Comparable<T>> TreeNode<T> insert(TreeNode<T> root, T data) {
        if(root == null) {
            return new TreeNode<T>(data,null,null);
        }

        if(root.data.compareTo(data)>0) {
            if(root.left == null) {
                root.left = new TreeNode<T>(data,null,null);;
            } else {
                insert(root.left, data);
            }
        } else if(root.data.compareTo(data)<=0) {
            if(root.right == null) {
                root.right = new TreeNode<T>(data,null,null);;
            } else {
                insert(root.right, data);
            }
        }
        return null;
    }





    public static void main(String[] args) {
        TreeNode<Integer>  root = insert(null,12);
        insert(root,13);
        insert(root,10);
        insert(root,11);
        insert(root,5);
        insert(root,3);
        insert(root,7);
        insert(root,8);
        insert(root,6);

        System.out.println(countNodesInRange(root,3,10));
        System.out.println(countNodesInRange2(root,3,10));

    }





}
