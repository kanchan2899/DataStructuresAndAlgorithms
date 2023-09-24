package com.dsalgo.trees;

// https://leetcode.com/problems/symmetric-tree/
public class IsMirrorTree {
    Node root;

    static boolean isMirrorTree(Node root) {
        return (root == null || helper(root.left, root.right));
    }

    private static boolean helper(Node left, Node right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null) {
            return false;
        }

        return (left.data == right.data && helper(left.left, right.right) && helper(left.right, right.left));
    }

    public static void main(String[] args) {
        IsMirrorTree tree = new IsMirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);

        System.out.println(isMirrorTree(tree.root));
    }
}
