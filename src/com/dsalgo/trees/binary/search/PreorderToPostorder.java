package com.dsalgo.trees.binary.search;

// https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/
public class PreorderToPostorder {
    Node root;

    static void findPostorder(int[] preorder) {
        INT preIndex = new INT(0);

        helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, preIndex);
    }

    static private void helper(int[] preorder, int minValue, int maxValue, INT preIndex) {
        // if entire preorder array is traversed, then return
        if(preIndex.data == preorder.length) {
            return;
        }

        // if array element does not lie in range specified, then it is not a part of current subtree
        if(preorder[preIndex.data] < minValue || preorder[preIndex.data] > maxValue) {
            return;
        }

        // store current value, to be printed later, after printing left and right subtrees.
        // Increment preIndex to find left and right subtrees, and pass this updated value to recursive
        // calls
        int val = preorder[preIndex.data];
        preIndex.data++;

        // all elements with value between minVal and val lies in the left subtree
        helper(preorder, minValue, val, preIndex);

        // all elements with value between val and maxVal lies in the right subtree
        helper(preorder, val, maxValue, preIndex);

        System.out.print(val + " ");
    }

    public static void main(String[] args) {
        int pre[] = { 40, 30, 35, 80, 100 };

        findPostorder(pre);
    }
}

class INT {
    int data;

    INT(int d) {
        data = d;
    }
}
