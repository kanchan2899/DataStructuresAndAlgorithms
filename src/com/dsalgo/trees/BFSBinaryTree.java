package com.dsalgo.trees;

// https://www.geeksforgeeks.org/level-order-tree-traversal/

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class BFSBinaryTree {
    Node root;

    public BFSBinaryTree() {
        root = null;
    }

    void printLevelOrder() {
        int h = height(root);
        int i;
        for(i = 1; i <= h; i++) {
            printCurrentOrder(root, i);
        }
    }

    void printLevelOrderUsingQueue() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    private void printCurrentOrder(Node root, int level) {
        if(root == null)
            return;

        if(level == 1) {
            System.out.print(root.data + " ");
        } else if(level > 1) {
            printCurrentOrder(root.left, level - 1);
            printCurrentOrder(root.right, level - 1);
        }
    }

    private int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        if(lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    public static void main(String[] args) {
        BFSBinaryTree tree = new BFSBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
        System.out.println();
        System.out.println("Level order traversal of binary tree using queue is ");
        tree.printLevelOrderUsingQueue();
    }
}
