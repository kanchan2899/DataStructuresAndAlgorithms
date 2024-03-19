package com.dsalgo.grokking.patterns.tree.bfs;

public class PopulateNextRightPointerInEachNode {

    public static TreeWithNextNode populateNextPointers(TreeWithNextNode root) {
        // if root is null, return null
        if(root == null) {
            return null;
        }

        // initialize the mostLeft node as the root
        TreeWithNextNode mostLeft = root;

        // Loop until there are no more levels below
        while (mostLeft.left != null) {
            // initialize the current node as the mostLeft node of the current level
            TreeWithNextNode current = mostLeft;

            // loop through the current level
            while (current != null) {
                // connect the current node's left child to its right child
                current.left.next = current.right;

                // if there is a next node on the same level
                if(current.next != null) {
                    // connect the current node's right child to the left child of its next node
                    current.right.next = current.next.left;
                }

                // move to the next node on the same level
                current = current.next;
            }
            // move down to the next level
            mostLeft = mostLeft.left;
        }
        // return the modified root node with the connections between nodes
        return root;
    }
}
