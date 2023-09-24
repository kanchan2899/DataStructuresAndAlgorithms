package com.dsalgo.trees.binary.search;

// https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
public class CheckForBST {

    Node root;

    /**
     * For each node, check if the left node of it is smaller than the node and right node of
     * it is greater than the node.
     *
     * TC: O(n)
     * SC: O(height)
     *
     * @param root
     * @return
     */
    boolean isBST(Node root) {
        if(root == null) {
            return true;
        }

        // false if left > node
        if(root.left != null && root.left.data > root.data) {
            return false;
        }

        // false if right < node
        if(root.right != null && root.right.data < root.data) {
            return false;
        }

        // false if recursively, the left or right is not a BST
        if(!isBST(root.left) || !isBST(root.right)) {
            return false;
        }

        // passing all conditions means a BST
        return true;
    }

    /**
     * For each node, check if max value in left subtree is smaller than the node and min
     * value in right subtree greater than the node.
     *
     * TC: O(n ^ 2) - in case of skew tree
     * SC: O(height)
     *
     * @param node
     * @return
     */
    boolean isBST1(Node node) {
        if(node == null) {
            return true;
        }

        // false if the max of left > node
        if(node.left != null && maxValue(node.left) >= node.data) {
            return false;
        }

        // false if min of right <= node
        if(node.right != null && minValue(node.right) <= node.data) {
            return false;
        }

        // false if recursively the left or right is not a BST
        if(!isBST(node.left) || !isBST(node.right)) {
            return false;
        }

        // passing all conditions means a BST
        return true;
    }

    private int maxValue(Node node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }

        if(node.right == null) {
            return node.data;
        }
        return maxValue(node.right);
    }

    private int minValue(Node node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }

        if(node.left == null) {
            return node.data;
        }
        return Math.min(minValue(node.left), node.data);
    }

    /**
     * Maintain min and max value for each node to have a range and check if the node's value lies in
     * the range recursively for subtrees.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param node
     * @return
     */
    boolean isBST2(Node node) {
        return helper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(Node node, int minValue, int maxValue) {
        if(node == null) {
            return true;
        }

        // false if the node violates the min/max constraints
        if(node.data < minValue || node.data > maxValue) {
            return false;
        }

        // check the subtrees recursively tightening the min/max constraints
        return (helper(node.left, minValue, node.data - 1) &&
                helper(node.right, node.data + 1, maxValue));
    }

    /**
     * The idea is to utilize the property - inorder traversal of BST is always sorted
     *
     * TC: O(n)
     * SC: O(height)
     */
    int prev = Integer.MIN_VALUE;
    private boolean isBST3(Node root) {
        if(root == null) {
            return true;
        }

        if(!isBST3(root.left)) {
            return false;
        }
        if(root.data <= prev) {
            return false;
        }

        return isBST3(root.right);
    }

    public static void main(String[] args) {
        CheckForBST tree = new CheckForBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        System.out.println(tree.isBST(tree.root));
        System.out.println(tree.isBST1(tree.root));
        System.out.println(tree.isBST2(tree.root));
        System.out.println(tree.isBST3(tree.root));
    }


}
