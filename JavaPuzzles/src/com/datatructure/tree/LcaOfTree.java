package com.datatructure.tree;

public class LcaOfTree {
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
        LcaOfTree tree = new LcaOfTree();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        tree.root.right = new TreeNode(22);

        System.out.println(tree.toString());
        //tree.findLca(10,14);
        System.out.println(tree.findLca(4,14));
        System.out.println(tree.findLca(22,10));

    }

    private int findLca(int i, int j) {
        return  findLca(root, i, j).data;

    }

    private TreeNode findLca(TreeNode current, int i, int j) {
        if(current == null) return null;
        if(current.data == i || current.data == j) {
            return current;
        }
        TreeNode found1 = findLca(current.left,i,j);
        TreeNode found2 = findLca(current.right,i,j);

        if(found1!=null && found2!=null) return current;

        return found1!=null?found1:found2;

    }


}
