package com.dsalgo.trees;

// https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/

import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    int data;
    ListNode next;
    ListNode(int d) {
        data = d;
        next = null;
    }
}
public class MakeBinaryTreeFromLL {
    Node root;

    static ListNode head;

    static void push(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    /**
     * 1. Create an empty queue.
     * 2. Make the first node of the list as root, and enqueue it to the queue.
     * 3. Until we reach the end of the list, do the following.
     * ………a. Dequeue one node from the queue. This is the current parent.
     * ………b. Traverse two nodes in the list, add them as children of the current parent.
     * ………c. Enqueue the two nodes into the queue.
     *
     * TC: O(n)
     * SC: O(width of tree)
     *
     * @param node
     * @return
     */
    static Node constructTree(Node node) {
        Queue<Node> queue = new LinkedList<>();

        if(head == null) {
            node = null;
            return null;
        }

        node = new Node(head.data);

        queue.add(node);

        head = head.next;

        while (head != null) {
            Node parent = queue.peek();

            Node left = null, right = null;

            left = new Node(head.data);

            queue.add(left);
            head = head.next;

            if(head != null) {
                right = new Node(head.data);
                queue.add(right);
                head = head.next;
            }

            parent.left = left;
            parent.right = right;

            queue.poll();

        }
        return node;
    }

    static void inorderTraversal(Node node)
    {
        if (node != null)
        {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        MakeBinaryTreeFromLL tree = new MakeBinaryTreeFromLL();

        tree.push(36);
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10);

        Node root = constructTree(tree.root);

        inorderTraversal(root);
    }
}
