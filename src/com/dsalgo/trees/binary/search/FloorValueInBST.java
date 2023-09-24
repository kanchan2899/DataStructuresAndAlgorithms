package com.dsalgo.trees.binary.search;

public class FloorValueInBST extends BinarySearchTree{
    Node root;

    /**
     * Recursive solution: if the node's data is equal to the key, return the node.
     * If it is greater than key, recursively traverse left subtree. Otherwise, traverse right
     * subtree. If the floor value of right subtree is less than equal to key, return floor value,
     * otherwise return node's data.
     *
     * TC: O(height)
     * SC: O(height)
     *
     * @param root
     * @param key
     * @return
     */
    int floor(Node root, int key) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        // if root's data is equal to key
        if(root.data == key) {
            return root.data;
        }

        // if root's data is greater than key, floor value lies in the left subtree
        if(root.data > key) {
            return floor(root.left, key);
        }

        // Otherwise, floor lies in the rigth subtree
        int floorValue = floor(root.right, key);

        return (floorValue <= key) ? floorValue : root.data;

    }

    int floorIterative(Node root, int key) {
        Node result = null;

        while(root != null) {
            if(root.data == key) {
                return root.data;
            }
            else if(root.data > key) {
                root = root.left;
            } else {
                result = root;
                root = root.right;
            }
        }

        if(result == null) {
            return -1;
        }
        return result.data;
    }

    public static void main(String[] args) {
        FloorValueInBST tree = new FloorValueInBST();
        tree.root = tree.insert(null, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);
        System.out.println("Floor value in BST is " + tree.floor(tree.root, 75));
        System.out.println("Floor value in BST is " + tree.floorIterative(tree.root, 75));
    }
}
