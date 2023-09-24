package com.dsalgo.trees.binary.search;

// https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
public class KthSmallestInBST extends BinarySearchTree{
    int count = 0;

    public static void main(String[] args) {
        KthSmallestInBST tree = new KthSmallestInBST();
        tree.insert(null, 10);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 11);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 4);

        tree.inorder(tree.root);
        System.out.println(tree.kthSmallest(tree.root, 5));
    }

    private int kthSmallest(Node root, int k) {
        Node result = helper(root, k);
        if(result == null) {
            return -1;
        } else {
            return result.data;
        }
    }

    private Node helper(Node root, int k) {
        if(root == null) {
            return null;
        }

        Node left = helper(root.left, k);
        if(left != null) {
            return left;
        }

        count++;

        if(count == k) {
            return root;
        }

        return helper(root.right, k);
    }
}
