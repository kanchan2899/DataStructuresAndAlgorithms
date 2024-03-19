package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList{

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        // assign current to root
        TreeNode current = root;
        TreeNode last = null;

        // traverse the tree
        while (current != null) {
            if(current.left != null) {
                last = current.left;

                // if the last node has a right child
                while(last.right != null) {
                    last = last.right;
                }
                last.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }
}
