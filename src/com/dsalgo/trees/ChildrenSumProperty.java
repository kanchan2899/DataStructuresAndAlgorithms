package com.dsalgo.trees;

// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
public class ChildrenSumProperty {
    Node root;
    static boolean childrenSumProperty(Node root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if(root.left != null) {
            sum += root.left.data;
        }
        if(root.right != null) {
            sum += root.right.data;
        }
        return (root.data == sum && childrenSumProperty(root.left) && childrenSumProperty(root.right));
    }
    public static void main(String[] args) {
        ChildrenSumProperty tree = new ChildrenSumProperty();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        System.out.println("Does children sum property hold true? " + childrenSumProperty(tree.root));
    }
}
