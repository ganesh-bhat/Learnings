package com.datatructure.tree;

import java.util.ArrayList;
import java.util.List;

public class FlatenTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  TreeNode root;
  public FlatenTree() {
    root = makeTree();
  }

    public TreeNode makeTree() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        return node;
    }

    TreeNode prev;
    public void flatten(TreeNode root) {
      if(root == null) return;

      TreeNode left = root.left;
      TreeNode right = root.right;
      if(prev == null) prev = root;
      else prev.right = root;
      prev.left = null;
      prev = root;

     flatten(left);
     flatten(right);


    }

    public static void main(String[] args) {
        FlatenTree tree = new FlatenTree();
        tree.flatten(tree.root);
        tree.print();
    }

    private void print() {
        print(root);
    }

    private void print(TreeNode root) {
      while(root!=null) {
          System.out.println(root.val);
          root = root.right;
      }
    }


}
