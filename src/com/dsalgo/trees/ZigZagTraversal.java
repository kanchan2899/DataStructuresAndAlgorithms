package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/zigzag-tree-traversal/
public class ZigZagTraversal {
    Node root;
    static ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                Node current = queue.poll();
                level.add(current.data);

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }
            }

            if(!leftToRight) {
                Collections.reverse(level);
            }

            result.addAll(level);
            leftToRight = !leftToRight;
        }
        return result;
    }
    public static void main(String[] args) {
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println(zigZagTraversal(tree.root));
    }
}
