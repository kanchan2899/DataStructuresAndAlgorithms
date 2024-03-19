package com.dsalgo.grokking.patterns.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        // create a queue and insert root's left and right node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            // deque two elements from queue and store in left and right variables
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // if both elements are null, move to the next iteratio
            if(left == null && right == null) {
                continue;
            }

            // if any one element is null, tree is asymmetric, return false
            if(left == null || right == null) {
                return false;
            }

            // if left element's value is not equal to the right element's value
            if(left.val != right.val) {
                return false;
            }

            // append nodes in the queue
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        // the queue is empty now, indicates that all the elements are matched
        return true;
    }
}
