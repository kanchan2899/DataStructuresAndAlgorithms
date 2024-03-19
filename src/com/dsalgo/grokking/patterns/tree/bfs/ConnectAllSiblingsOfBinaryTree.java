package com.dsalgo.grokking.patterns.tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://stackoverflow.com/questions/69470354/connect-all-siblings-in-binary-tree-using-pointers
public class ConnectAllSiblingsOfBinaryTree {
    public static void populateSiblingsPointers(TreeWithNextNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeWithNextNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeWithNextNode dummy = new TreeWithNextNode(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeWithNextNode current = queue.poll();
                dummy.next = current;
                dummy = dummy.next;
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        dummy.next = null;
    }
}
