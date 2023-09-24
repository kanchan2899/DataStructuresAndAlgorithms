package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
public class RightViewOfBinaryTree {
    Node root;
    static int maxLevel;

    /**
     * Using Level order traversal (BFS) : The idea is to use Level Order Traversal as the last
     * node every level gives the right view of the binary tree.
     *
     * 1. Perform level order traversal on the tree
     * 2. At every level print the last node of that level
     *
     * TC: O(n)
     * SC: O(width of tree)
     *
     * @param root
     * @return
     */
    static List<Integer> rightView(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                Node current = q.poll();
                if(i == n - 1) {
                    list.add(current.data);
                }
                if(current.left != null) {
                    q.add(current.left);
                }
                if(current.right != null) {
                    q.add(current.right);
                }
            }
        }
        return list;
    }

    static List<Integer> rightView1(Node root) {
        return helper(root, 1);
    }

    private static List<Integer> helper(Node root, int level) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        if(maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }

        list.addAll(helper(root.right, level + 1));
        list.addAll(helper(root.left, level + 1));

        return list;
    }

    public static void main(String[] args) {
        RightViewOfBinaryTree tree = new RightViewOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println(rightView(tree.root));
        System.out.println(rightView1(tree.root));
    }
}
