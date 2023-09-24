package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
public class MaximumWidthOfBinaryTree {
    Node root;

    /**
     * Using BFS: To get the width of each level we can use the level order traversal.
     * The maximum among the width of all levels is the required answer.
     *
     * TC: O(n)
     * SC: O(width of tree)
     *
     * @param root
     * @return
     */
    static int maxWidth(Node root) {
        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int maxWidth = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();
            maxWidth = Math.max(maxWidth, nodesAtCurrentLevel);
            for(int i = 0; i < nodesAtCurrentLevel; i++) {
                Node current = queue.poll();

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree tree = new MaximumWidthOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Maximum width of the binary tree is " + maxWidth(tree.root));
    }
}
