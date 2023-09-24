package com.dsalgo.trees;

public class DepthFirstTraversal {

    Node root;
    DepthFirstTraversal() {
        root = null;
    }

    static void printPostOrder(Node node) {
        if(node == null) {
            return;
        }

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }

    static void printPreOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    static void printInOrder(Node node) {
        if(node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        DepthFirstTraversal tree = new DepthFirstTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        System.out.print("Preorder traversal: ");
        printPreOrder(tree.root);
        System.out.print("Inorder traversal: ");
        printInOrder(tree.root);
        System.out.print("Postorder traversal: ");
        printPostOrder(tree.root);
    }

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
