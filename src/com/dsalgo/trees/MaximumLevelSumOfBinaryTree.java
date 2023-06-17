package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
class MaximumLevelSumOfBinaryTree {
    TreeNode root;

    public int maxLevelSum() {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        int minLevel = 0, maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            int levelSum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                levelSum += node.val;

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            if(levelSum > maxSum) {
                maxSum = levelSum;
                minLevel = level;
            }
        }
        return minLevel;
    }

    public static void main(String[] args) {
        MaximumLevelSumOfBinaryTree binaryTree = new MaximumLevelSumOfBinaryTree();
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.left.right = new TreeNode(5);

        System.out.println("Maximum level sum of binary tree is " + binaryTree.maxLevelSum());
    }
}
