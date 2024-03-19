package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementInBST {

    static int count = 0;
    static int result = Integer.MIN_VALUE;

    public static int kthSmallestElement(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private static void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        traverse(root.left, k);

        count++;
        if(count == k) {
            result = root.val;
            return;
        }

        traverse(root.right, k);
    }
}
