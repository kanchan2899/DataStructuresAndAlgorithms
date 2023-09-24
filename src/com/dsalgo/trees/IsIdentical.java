package com.dsalgo.trees;

// https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
public class IsIdentical {
    Node root;

    /**
     * Traverse both trees and if their data are same, return true.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root1
     * @param root2
     * @return
     */
    boolean isIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if((root1 == null && root2 != null) || root1 != null && root2 == null) {
            return false;
        }

        return (root1.data == root2.data && isIdentical(root1.left, root2.left) &&
                isIdentical(root1.right, root2.right));
    }

}
