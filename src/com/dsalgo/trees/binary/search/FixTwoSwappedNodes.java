package com.dsalgo.trees.binary.search;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
public class FixTwoSwappedNodes {
    Node first, middle, last, prev;
    public void correctBST(Node root) {
        first = middle = last = prev = null;

        // set the pointers to find out two nodes
        helper(root);

        // fix the tree
        if(first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && last == null) {
            // adjacent nodes swapped
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
        // otherwise nodes have not been swapped, the tree is already a BST
    }

    private void helper(Node root) {
        if(root != null) {
            // recur for the left subtree
            helper(root.left);

            // if this node is smaller than the previous node, its violating the BST
            if(prev != null && root.data < prev.data) {
                if(first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }

            // make this node as prev
            prev = root;

            // recur right subtree
            helper(root.right);
        }
    }

    void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        FixTwoSwappedNodes tree = new FixTwoSwappedNodes();

        tree.inorder(root);
        System.out.println();
        tree.correctBST(root);
        tree.inorder(root);
    }
}
