package com.dsalgo.trees.binary.search;

public class MinimumValueinBST extends BinarySearchTree{
    Node root;

    /**
     *
     * Traverse to the leftmost node in the BST
     *
     * TC: O(height)
     * SC: O(height)
     * @param node
     * @return
     */
    public int minValue(Node node) {
        if(node == null) {
            return -1;
        }
        if(node.left == null) {
            return node.data;
        } else {
            return minValue(node.left);
        }
    }

    public static void main(String[] args) {
        MinimumValueinBST tree = new MinimumValueinBST();
        tree.root = tree.insert(null, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);
        System.out.println("Minimum value in BST is " + tree.minValue(tree.root));
    }
}
