package com.datatructure.tree;

import javax.transaction.TransactionRequiredException;

public class FindTiltNode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        return Math.abs(left-right);
    }


}
