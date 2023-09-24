package com.dsalgo.trees;

// https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
public class MaximumInBinaryTree {
    Node root;
    static int getMax(Node root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }

    public static void main(String[] args) {
        MaximumInBinaryTree tree = new MaximumInBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println("Maximum in binary tree is " + getMax(tree.root));
    }
}
