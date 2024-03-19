package com.dsalgo.grokking.patterns.tree.dfs;

public class BinaryTreeMaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        int current_max = left + right + root.val;

        max = Math.max(current_max, max);

        return Math.max(left, right) + root.val;
    }
}
