package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfABinaryTree {
    public static int depthOfTree(TreeNode root) {
        return helper(root, 0);
    }

    private static int helper(TreeNode root, int depth) {
        if(root == null) {
            return depth;
        }

        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);

        return Math.max(left, right);
    }
}
