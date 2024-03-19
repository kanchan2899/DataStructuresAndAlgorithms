package com.dsalgo.grokking.patterns.tree.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class BinaryTreeZigZagTraversal {
    public static List<List<Integer>> zigzagTraversal(TreeNode root) {
        // if root is null, return an empty list
        if(root == null) {
            return new ArrayList<>();
        }

        // create a deque with the root node as the only element
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        // create an empty list to indicate the direction of the traversal
        List<List<Integer>> zigzagTraversal = new ArrayList<>();

        // flag to indicate the direction of the traversal
        boolean reverse = false;

        // traverse the tree
        while (!deque.isEmpty()) {
            // get the size of the current level
            int size = deque.size();

            // insert an empty list at the end of zigzagTraversal list
            zigzagTraversal.add(new ArrayList<Integer>());

            // traverse the nodes in the current level
            for(int i = 0; i < size; i++) {
                if(!reverse) {
                    // if the direction is left-to-right, pop a node from the start (left) of the
                    // deque and add it to the current level
                    TreeNode node = deque.pollFirst();
                    zigzagTraversal.get(zigzagTraversal.size() - 1).add(node.val);

                    // add the left and right child of the current node to the deque
                    if(node.left != null) {
                        deque.addLast(node.left);
                        deque.addLast(node.right);
                    }
                } else {
                    // if the direction is right-to-left, pop a node from the back (right) of the
                    // deque and add it to the current level
                    TreeNode node = deque.pollLast();
                    zigzagTraversal.get(zigzagTraversal.size() - 1).add(node.val);

                    // add the right and left child nodes of the current node to the queue
                    if(node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if(node.left != null) {
                        deque.addFirst(node.left);
                    }
                }

            }
            // reverse the direction of traversal for the next level
            reverse = !reverse;
        }
        return zigzagTraversal;
    }
}
