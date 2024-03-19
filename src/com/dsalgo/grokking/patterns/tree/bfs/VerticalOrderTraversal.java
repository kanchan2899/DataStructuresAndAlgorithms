package com.dsalgo.grokking.patterns.tree.bfs;

import java.util.*;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversal {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) {
            return levelOrder;
        }

        Map<Integer, ArrayList<Integer>> nodeList = new HashMap<>();

        // map of node and its column offset
        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();

        int column = 0;

        queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root, column));

        int minColumn = 0;
        int maxIndex = 0;

        // traverse over the nodes in the queue
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> p = queue.poll();

            root = p.getKey();
            column = p.getValue();

            if(root != null) {
                if(!nodeList.containsKey(column)) {
                    nodeList.put(column, new ArrayList<>());
                }

                nodeList.get(column).add(root.val);

                // get min and max column numbers for the tree
                minColumn = Math.min(minColumn, column);
                maxIndex = Math.max(maxIndex, column);

                // add current node's left and right child in the queue
                queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root.left, column - 1));
                queue.offer(new AbstractMap.SimpleEntry<TreeNode, Integer>(root.right, column + 1));
            }
        }

        for(int i = minColumn; i < maxIndex + 1; i++) {
            levelOrder.add(nodeList.get(i));
        }
        return levelOrder;
    }
}
