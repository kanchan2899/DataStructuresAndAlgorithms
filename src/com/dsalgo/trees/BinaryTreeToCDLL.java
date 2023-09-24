package com.dsalgo.trees;

public class BinaryTreeToCDLL {
    Node root;

    static Node prev = null;

    static Node binaryTreeToCDLL(Node root) {
        if(root == null) {
            return root;
        }

        Node head = binaryTreeToCDLL(root.left);

        if(prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        binaryTreeToCDLL(root.right);

        head.left = prev;
        prev.right = head;

        return head;
    }

    static void printCDLL(Node head) {
        Node current = head;

        while (current != head) {
            System.out.print(current.data + " -> ");
            current = current.right;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        BinaryTreeToCDLL tree = new BinaryTreeToCDLL();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node cdll = binaryTreeToCDLL(tree.root);

        printCDLL(cdll);
    }
}
