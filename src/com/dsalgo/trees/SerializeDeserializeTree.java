package com.dsalgo.trees;

import java.util.ArrayList;

public class SerializeDeserializeTree {
    Node root;

    static final int EMPTY = -1;
    static int index = 0;

    /**
     * Using markers and preorder traversal
     *
     * 1. Store all possible child nodes for each node.
     * 2. If there is no child node then push -1 for that child.
     * 3. Put this preorder traversal in the file.
     *
     * TC: O(n)
     * SC: O(height)
     *
     * @param root
     * @param arr
     */
    static void serialize(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            arr.add(EMPTY);
            return;
        }
        arr.add(root.data);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    /**
     * Deserialization can be done by simply reading data from the file one by one and keep on
     * adding children till a -1 is reached. If both the children are NULL then return back
     * to the parent.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    static Node deserialize(ArrayList<Integer> arr) {
        if(index == arr.size())
            return null;

        int val = arr.get(index);
        index++;

        if(val == EMPTY)
            return null;

        Node root = new Node(val);
        root.left = deserialize(arr);
        root.right = deserialize(arr);

        return root;
    }

    static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        SerializeDeserializeTree tree = new SerializeDeserializeTree();

        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.right = new Node(7);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        serialize(tree.root, arr);
        System.out.println(arr);

        Node root = deserialize(arr);
        preorder(root);
    }
}
