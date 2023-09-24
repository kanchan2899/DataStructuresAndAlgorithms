package com.dsalgo.trees;

import java.util.HashMap;

// https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
public class BinaryTreeFromInorderPreorder {
    Node root;
    static int preorderIndex = 0;
    static int preorderIndex1 = 0;
    static HashMap<Integer,Integer> inorderMap = new HashMap<>();

    /**
     * 1. Pick an element from Preorder. Increment a Preorder Index Variable
     * to pick the next element in the next recursive call.
     * 2. Create a new tree node tNode with the data as the picked element.
     * 3. Find the picked element’s index in Inorder. Let the index be inIndex.
     * 4. Call buildTree for elements before inIndex and make the built tree as a left subtree
     * of tNode.
     * 5. Call buildTree for elements after inIndex and make the built tree as a right subtree
     * of tNode.
     * 6. return tNode.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param inorder
     * @param preorder
     * @param inorderStart
     * @param inorderEnd
     * @return
     */
    static Node constructTree(int[] inorder, int[] preorder, int inorderStart, int inorderEnd) {
        if(inorderStart > inorderEnd) {
            return null;
        }
        int val = preorder[preorderIndex];
        preorderIndex++;
        Node root = new Node(val);

        // If this node has no children then return
        if(inorderStart == inorderEnd) {
            return root;
        }

        int inorderIndex = searchInorder(inorder, inorderStart, inorderEnd, root.data);

        root.left = constructTree(inorder, preorder, inorderStart, inorderIndex - 1);
        root.right = constructTree(inorder, preorder, inorderIndex + 1, inorderEnd);

        return root;
    }

    static int searchInorder(int[] inorder, int start, int end, int val) {
        int k;
        for(k = start; k <= end; k++) {
            if(inorder[k] == val) {
                return k;
            }
        }
        return k;
    }

    /**
     * Store the inorder array in a map, so we can search for inorderIndex in O(1) time.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param inorder
     * @param preorder
     * @return
     */
    static Node constructTree1(int[] inorder, int[] preorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(inorder, preorder, 0, inorder.length - 1);
    }

    static Node helper(int[] inorder, int[] preorder, int inorderStart, int inorderEnd) {

        if(inorderStart > inorderEnd) {
            return null;
        }

        int val = preorder[preorderIndex1];
        preorderIndex1++;

        Node root = new Node(val);

        if(inorderStart == inorderEnd) {
            return root;
        }
        int inorderIndex = inorderMap.get(val);

        root.left = helper(inorder, preorder, inorderStart, inorderIndex - 1);
        root.right = helper(inorder, preorder, inorderIndex + 1, inorderEnd);

        return root;

    }

    static void printTree(Node root) {
        if(root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {20, 10, 30};
        int[] preorder = {10, 20, 30};

        BinaryTreeFromInorderPreorder tree = new BinaryTreeFromInorderPreorder();
        tree.root = constructTree(inorder, preorder, 0, inorder.length - 1);
        printTree(tree.root);
        System.out.println();
        tree.root = constructTree1(inorder, preorder);
        printTree(tree.root);
    }
}
