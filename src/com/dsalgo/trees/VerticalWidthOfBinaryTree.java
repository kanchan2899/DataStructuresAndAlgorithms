package com.dsalgo.trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/width-binary-tree-set-1/
public class VerticalWidthOfBinaryTree {
    Node root;
    static int maximum, minimum;

    /**
     * Using DFS and inorder traversal: Take inorder traversal and then take a temp variable to
     * keep the track of unique vertical paths. when moving to left of the node then temp decreases by
     * one and if goes to right then temp value increases by one. If the minimum is greater
     * than temp, then update minimum = temp and if maximum less than temp then update
     * maximum = temp. The vertical width of the tree will be equal to abs(minimum ) + maximum.
     *
     * 1. Initialize a minimum and maximum variable to track the left-most and right-most index.
     * 2. Run Depth-first search traversal and maintain the current horizontal index curr,
     * for root curr = 0.
     *      a. Traverse left subtree with curr = curr-1
     *      b. Update maximum with curr if curr > maximum.
     *      c. Update minimum with curr if curr < minimum.
     *      d. Traverse right subtree with curr = curr + 1.
     * 3. Print the vertical width of the tree i.e. abs(minimum ) + maximum.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    static int verticalWidthOfTree(Node root) {
        maximum = 0;
        minimum = 0;
        helper(root, 0);
        return (Math.abs(minimum) + maximum) + 1;
    }

    private static void helper(Node root, int current) {
        if(root == null) {
            return;
        }

        // traverse left
        helper(root.left, current - 1);

        // if current decreased, update minimum
        if(current < minimum) {
            minimum = current;
        }

        // if current increased, update maximum
        if(current > maximum) {
            maximum = current;
        }

        // traverse right
        helper(root.right, current + 1);
    }

    /**
     * Using BFS: Create a class to store the node and the horizontal level of the node. The
     * horizontal level of left node will be 1 less than its parent, and horizontal level of
     * the right node will be 1 more than its parent. We create a minLevel variable to store
     * the minimum horizontal level or the leftmost node in the tree, and a maxLevel variable
     * to store the maximum horizontal level or the rightmost node in the tree. Traverse the
     * tree in level order and store the minLevel and maxLevel. In the end, print sum of
     * maxLevel and absolute value of minLevel which is the vertical width of the tree.
     *
     * 1. Initialize two variables maxLevel = 0 and minLevel = 0 and queue Q of pair of the type
     * (Node*, Integer).
     * 2. Push (root, 0) in Q.
     * 3. Run while loop till Q is not empty
     *      a. Store the front node of the Queue in cur and the current horizontal level in count.
     *      b. If curr->left is not null then push (root->left, count-1) and update minLevel
     *      with min(minLevel, count-1).
     *      c. If curr->right is not null then push (root->right, count+1) and update maxLevel
     *      with max(maxLevel, count+1).
     * 4. Print maxLevel + abs(minLevel) + 1.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    static int verticalWidthOfTree1(Node root) {
        maximum = minimum = 0;
        helper1(root);
        return (Math.abs(minimum) + maximum) + 1;
    }

    private static void helper1(Node root) {
        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.remove();

            if(current.node.left != null) {
                queue.add(new Pair(current.node.left, current.level - 1));
                minimum = Math.min(minimum, current.level - 1);
            }

            if(current.node.right != null) {
                queue.add(new Pair(current.node.right, current.level + 1));
                maximum = Math.max(maximum, current.level + 1);
            }
        }
    }

    static class Pair {
        Node node;
        int level; // Horizontal Level
        Pair(Node node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        VerticalWidthOfBinaryTree tree = new VerticalWidthOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Vertical width of tree using DFS is " + verticalWidthOfTree(tree.root));
        System.out.println("Vertical width of tree using BFS is " + verticalWidthOfTree1(tree.root));
    }
}
