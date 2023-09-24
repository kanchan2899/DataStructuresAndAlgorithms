package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/level-order-tree-traversal/
public class LevelOrderTraversal {
    Node root;

    LevelOrderTraversal() {
        root = null;
    }

    /**
     * Using queue:
     *
     * 1. Create an empty queue q.
     * 2. Push the root node of tree to q. That is, q.push(root).
     * 3. Loop while the queue is not empty:
     *      a. Pop the top node from queue and print the node.
     *      b. Enqueue node's children (first left then right children) to q
     *      c. Repeat the process until queue is not empty.
     *
     * TC: O(n)
     * SC: O(n), width of tree
     * @param root
     */
    static void levelOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    static void levelOrderTraversal1(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {
            Node current = queue.poll();

            if(current == null) {
                System.out.println();
                queue.add(null);
                continue;
            }

            System.out.print(current.data + " ");
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    static void levelOrderTraversal2(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        levelOrderTraversal(tree.root);
        System.out.println();
        levelOrderTraversal1(tree.root);
        System.out.println();
        levelOrderTraversal2(tree.root);

    }
}
