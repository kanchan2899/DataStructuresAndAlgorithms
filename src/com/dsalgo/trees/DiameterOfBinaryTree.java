package com.dsalgo.trees;


import java.util.HashMap;

// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class DiameterOfBinaryTree {

    Node root;

    /**
     * 1. the diameter of T’s left subtree.
     * 2. the diameter of T’s right subtree.
     * 3. the longest path between leaves that goes through the root of T
     * (this can be computed from the heights of the subtrees of T)
     *
     * @param root
     * @return
     */
    static int diameter(Node root) {
        if(root == null) {
            return 0;
        }

        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }

    private static int height(Node root) {
        if(root == null) {
            return 0;
        }
        return (1 + height(root.left) + height(root.right));
    }

    static int diameter = 0;
    private static int height1(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height1(root.left);
        int rh = height1(root.right);

        diameter = Math.max(diameter, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }

    static int diameter1(Node root) {
        int h = height1(root);
        return diameter;
    }


    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println(diameter(tree.root));
        System.out.println(diameter1(tree.root));
    }

}
