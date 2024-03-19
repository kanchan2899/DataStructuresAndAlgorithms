package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
    public static boolean validateBST(TreeNode root) {
        // explicitly using array to pass prev by reference
        long[] prev = {Long.MIN_VALUE};
        return validateBSTHelper(root, prev);
    }

    private static boolean validateBSTHelper(TreeNode root, long[] prev) {
        if(root == null) {
            return true;
        }

        // if left subtree is not a valid bst, return false
        if(!validateBSTHelper(root.left, prev)) {
            return false;
        }
        // if current node is less than or equal to the previous node, the tree is not a valid BST
        if(root.val <= prev[0]) {
            return false;
        }

        prev[0] = root.val;

        // check right subtree
        return validateBSTHelper(root.right, prev);
    }
}
