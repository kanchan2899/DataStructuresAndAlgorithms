package com.dsalgo.grokking.patterns.tree.dfs;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // using a hashmap to store the inorder list to reduce the time complexity of search
        HashMap<Integer, Integer> mapping = new HashMap<>();

        // iterate through the inorder list and map each value to its index
        for(int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        // explicitly using an array to pass preorderIndex by reference
        int[] preorderIndex = {0};

        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, mapping, preorderIndex);

    }

    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> mapping, int[] preorderIndex) {
        // if left > right, it means there are no more nodes left to construct
        if(left > right) {
            return null;
        }

        // pick current node from preorder list using preorderIndex and increment preorderIndex
        int curr = preorder[preorderIndex[0]];

        preorderIndex[0]++;

        TreeNode root = new TreeNode(curr);

        // if this node has no children then return
        if(left == right) {
            return root;
        }

        // else find the index of this node in inorder list
        int inorderIndex = mapping.get(curr);

        // recursively build the left subtree  by calling buildTreeHelper on the elements in the
        // inorder list from left to inorderIndex - 1
        root.left = buildTreeHelper(preorder, inorder, left, inorderIndex - 1, mapping, preorderIndex);

        // recursively build the right subtree by calling buildTreeHelper on the elements in the
        // inorder list from inorderIndex + 1 to right
        root.right = buildTreeHelper(preorder, inorder, inorderIndex + 1, right, mapping, preorderIndex);

        return root;
    }
}
