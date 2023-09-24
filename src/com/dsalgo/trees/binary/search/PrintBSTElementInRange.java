package com.dsalgo.trees.binary.search;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
public class PrintBSTElementInRange extends BinarySearchTree{

    ArrayList<Integer> elements = new ArrayList<>();

    ArrayList<Integer> bstElementsInRange(Node root, int low, int high) {
        if(root == null) {
            return elements;
        }
        bstElementsInRange(root.left, low, high);
        if(root.data >= low && root.data <= high) {
            elements.add(root.data);
        }
        bstElementsInRange(root.right, low, high);
        return elements;
    }

    public static void main(String[] args) {
        PrintBSTElementInRange tree = new PrintBSTElementInRange();

        tree.root = tree.insert(null, 5);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 9);

        System.out.println(tree.bstElementsInRange(tree.root, 3, 9));
    }
}
