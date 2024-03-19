package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/invert-binary-tree/description/
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        // do a post-order traversal of the binary tree
        if(root.left != null) {
            invertTree(root.left);
        }
        if(root.right != null) {
            invertTree(root.right);
        }

        // swap the left and right nodes at current level
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
