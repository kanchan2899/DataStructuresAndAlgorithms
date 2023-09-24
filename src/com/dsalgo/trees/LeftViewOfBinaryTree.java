package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/print-left-view-binary-tree/
public class LeftViewOfBinaryTree {
    Node root;
    static int max_level;

    /**
     * Using Preorder traversal and recursion: Keep track of the level of a node by passing the
     * level as a parameter to all recursive calls and also keep track of the maximum level.
     * Whenever, we see a node whose level is more than maximum level so far, we print the node
     * because this is the first node in its level
     *
     * Note: We traverse the left subtree before right subtree.
     *
     * TC: O(n)
     * SC: O(h), height of binary tree
     *
     */
    static void leftView(Node root) {
       int current_level = 1;
       helper(root, current_level);
    }

    static private void helper(Node root, int current_level) {
        if(root == null) {
            return;
        }
        if(max_level < current_level) {
            System.out.print(root.data + " ");
            max_level = current_level;
        }

        helper(root.left, current_level + 1);
        helper(root.right, current_level + 1);
    }

    /**
     * Using BFS: The left view contains all nodes that are the first nodes in their levels.
     * A simple solution is to do level order traversal and print the first node in every level.
     *
     * 1. Do level order traversal of the tree.
     *  a. For each level keep a track of the current level and print the first encountered node
     *  of this level.
     *  b. Move to the next level.
     *
     * TC: O(n)
     * SC: O(width of tree)
     *
     * @param root
     */
    public static void leftView1(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
            // traverse all nodes at current level
            for(int i = 0; i < n; i++) {
                Node currentNode = queue.poll();
                // print the leftmost element at the level
                if(i == 0){
                    System.out.print(currentNode.data + " ");
                }

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.left = new Node(12);
        tree.root.right.right = new Node(15);
        tree.root.right.right.left = new Node(14);

        leftView(tree.root);
        System.out.println();
        leftView1(tree.root);
    }
}
