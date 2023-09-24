package com.dsalgo.trees.binary.search;

public class CeilValueInBST extends BinarySearchTree{
    Node root;

    /**
     * A) Root data is equal to key. We are done, root data is ceil value.
     * B) Root data < key value, certainly the ceil value can't be in left subtree.
     *    Proceed to search on right subtree as reduced problem instance.
     * C) Root data > key value, the ceil value may be in left subtree.
     *    We may find a node with is larger data than key value in left subtree,
     *    if not the root itself will be ceil node.
     *
     * TC: O(height)
     * SC: O(height)
     *
     * @param root
     * @param key
     * @return
     */
    int ceil(Node root, int key) {
        if(root == null) {
            return -1;
        }
        if(root.data == key) {
            return root.data;
        }
        if(root.data < key) {
            return ceil(root.right, key);
        }

        int ceil = ceil(root.left, key);
        return (ceil >= key ? ceil : root.data);
    }

    private int ceilIterative(Node root, int key) {
        Node ceil = null;

        while (root != null) {
            if(root.data == key) {
                return root.data;
            } else if(root.data < key) {
                root = root.right;
            } else {
                ceil = root;
                root = root.left;
            }
        }
        return ceil.data;
    }

    public static void main(String[] args) {
        CeilValueInBST tree = new CeilValueInBST();
        tree.root = tree.insert(null, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);
        System.out.println("Floor value in BST is " + tree.ceil(tree.root, 75));
        System.out.println("Floor value in BST is " + tree.ceilIterative(tree.root, 75));
    }


}
