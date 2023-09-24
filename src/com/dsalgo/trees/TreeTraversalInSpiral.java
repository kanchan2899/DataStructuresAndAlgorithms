package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
public class TreeTraversalInSpiral {
    Node root;

    /**
     * Using BFS
     *
     * TC: O(n)
     * SC: O(n)
     * @param root
     */
    static void printSpiral(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        boolean reverse = true;

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();

            for(int i = 0; i < count; i++) {
                Node current = queue.poll();

                if(reverse) {
                    stack.push(current.data);
                } else {
                    System.out.print(current.data + " ");
                }

                if(current.left != null) {
                    queue.add(current.left);
                }

                if(current.right != null) {
                    queue.add(current.right);
                }

            }
            if(reverse) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }

    /**
     * Using two stacks:
     *
     * 1. Push root to the stack s1
     * 2. While any of the two stacks is not empty
     *  a. Take out a node, print it
     *  b. Push children of the taken out node to s2
     * 3. While s2 is not empty
     *  a. Take out a node, print it
     *  b. Push children of the taken out node into s1 in reverse order
     *
     *  TC: O(n)
     *  SC: O(n)
     *
     * @param root
     */
    static void printSpiral1(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> reversedStack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty() || !reversedStack.isEmpty()) {
            while (!stack.isEmpty()) {
                Node current = stack.pop();
                System.out.print(current.data + " ");

                if(current.right != null) {
                    reversedStack.push(current.right);
                }
                if(current.left != null) {
                    reversedStack.push(current.left);
                }
            }
            System.out.println();
            while (!reversedStack.isEmpty()) {
                Node current = reversedStack.pop();
                System.out.print(current.data + " ");

                if(current.left != null) {
                    stack.push(current.left);
                }
                if(current.right != null) {
                    stack.push(current.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeTraversalInSpiral tree = new TreeTraversalInSpiral();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        printSpiral(tree.root);
        System.out.println();
        printSpiral1(tree.root);

    }
}
