package com.dsalgo.trees;

public class BinaryTreeToDLL {
    Node root;

    static Node prev = null;

    static Node binaryTreeToDLL(Node root) {
        if(root == null) {
            return root;
        }

        Node head = binaryTreeToDLL(root.left);

        if(prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        binaryTreeToDLL(root.right);

        return head;
    }

    static void printDLL(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.right;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node dll = binaryTreeToDLL(tree.root);

        printDLL(dll);
    }
}
