package com.dsalgo.grokking.patterns.tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {
    public static String levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return "None";
        }

        StringBuilder levelOrder = new StringBuilder();

        // Declare an array of two queues
        ArrayList<Queue<TreeNode>> queues = new ArrayList<>();
        queues.add(new ArrayDeque<TreeNode>());
        queues.add(new ArrayDeque<TreeNode>());

        // initialize the current and next queues
        Queue<TreeNode> currentQueue = queues.get(0);
        Queue<TreeNode> nextQueue = queues.get(1);

        // enqueue the root node into the current queue and setting the level to 0
        currentQueue.add(root);
        int level = 0;

        while (!currentQueue.isEmpty()) {
            TreeNode temp = currentQueue.poll();
            levelOrder.append(temp.val);

            if(temp.left != null) {
                nextQueue.add(temp.left);
            }

            if(temp.right != null) {
                nextQueue.add(temp.right);
            }

            if(currentQueue.isEmpty()) {
                ++level;
                if(!nextQueue.isEmpty()) {
                    levelOrder.append(" : ");
                }
                currentQueue = queues.get(level % 2);
                nextQueue = queues.get((level + 1) % 2);
            } else {
                levelOrder.append(", ");
            }
        }
        return levelOrder.toString();
    }
}
