package com.dsalgo.trees;

// https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/

class Result {
    int max = Integer.MIN_VALUE;
}
public class MaxDifferenceBetweenNodeAncestor {

    Node root;

    int maxDifference(Node root) {
        Result result = new Result();

        helper(root, result);

        return result.max;
    }
    int helper(Node root, Result result) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null) {
            return root.data;
        }
        int val = Math.min(helper(root.left, result), helper(root.left, result));

        result.max = Math.max(result.max, root.data - val);

        return Math.min(val, root.data);
    }

    public static void main(String[] args) {
        MaxDifferenceBetweenNodeAncestor tree = new MaxDifferenceBetweenNodeAncestor();

        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.right = new Node(7);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);

        System.out.println(tree.maxDifference(tree.root));

    }
}
