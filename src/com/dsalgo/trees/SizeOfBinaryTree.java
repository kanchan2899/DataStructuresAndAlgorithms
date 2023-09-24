package com.dsalgo.trees;

// https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
public class SizeOfBinaryTree {
    Node root;

    /**
     * Using DFS:
     * 1. If tree is empty then return 0
     * 2. Else
     *      (a) Get the size of left subtree recursively  i.e., call
     *           size( tree->left-subtree)
     *      (a) Get the size of right subtree recursively  i.e., call
     *           size( tree->right-subtree)
     *      (c) Calculate size of the tree as following:
     *             tree_size  =  size(left-subtree) + size(right-
     *                                subtree) + 1
     *      (d) Return tree_size
     *
     * TC: O(n)
     * SC: O(height)
     *
     * @param root
     * @return
     */
    static int getSize(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public static void main(String[] args) {
        SizeOfBinaryTree tree = new SizeOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println("Size of binary tree is " + getSize(tree.root));
    }
}
