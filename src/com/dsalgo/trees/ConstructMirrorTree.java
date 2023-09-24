package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
public class ConstructMirrorTree {

    Node root;

    /**
     * Using DFS: The idea is to traverse recursively and swap the right and left subtrees
     * after traversing the subtrees.
     *
     * 1. Call Mirror for left-subtree i.e., Mirror(left-subtree)
     * 2. Call Mirror for right-subtree i.e., Mirror(right-subtree)
     * 3. Swap left and right subtrees.
     *  temp = left-subtree
     *  left-subtree = right-subtree
     *  right-subtree = temp
     *
     *  TC: O(n)
     *  SC: O(n)
     *
     * @param root
     * @return
     */
    static Node mirror(Node root) {
        if(root == null) {
            return null;
        }

        // do the subtrees
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        // swap the left and right pointers
        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * Using BFS: The idea is to do queue-based level order traversal. While doing traversal,
     * swap left and right children of every node.
     * 1. Perform the level order traversal
     * 2. While traversing over the tree swap the left and right child of current node
     *
     * TC: O(n)
     * SC: O(width of tree)
     *
     * @param root
     * @return
     */
    static void mirror1(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // swap left and right nodes
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            // push left and right children
            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        ConstructMirrorTree tree = new ConstructMirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Original tree: ");
        inorder(tree.root);
        System.out.println();
        System.out.print("Mirror tree using DFS: ");
        mirror(tree.root);
        inorder(tree.root);
        System.out.println();
        System.out.print("Mirror tree using BFS: ");
        mirror1(tree.root);
        inorder(tree.root);
    }
}
