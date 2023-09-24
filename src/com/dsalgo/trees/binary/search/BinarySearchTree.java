package com.dsalgo.trees.binary.search;


class Node {
    int data;
    Node left, right;

    Node(int k) {
        data = k;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    public boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    public boolean searchIteratively(Node root, int key) {
        while (root != null) {
            if(root.data == key) {
                return true;
            } else if(root.data > key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    public Node insert(Node root, int key) {
        // if the tree is empty, return a new node
        if(root == null) {
            root = new Node(key);
            return root;
        }

        // otherwise recur the tree
        if(key < root.data) {
            root.left = insert(root.left, key);
        } else if(key > root.data) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data +  " ");
            inorder(root.right);
        }
    }

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

    public Node deleteNode(Node root, int key) {
        if(root == null) {
            return root;
        }

        if(root.data > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.data < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // this node to be deleted

            // node with only one child or no child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // node with two children, get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.root = binarySearchTree.insert(null, 50);
        binarySearchTree.root = binarySearchTree.insert(binarySearchTree.root, 30);
        binarySearchTree.root = binarySearchTree.insert(binarySearchTree.root, 20);
        binarySearchTree.root = binarySearchTree.insert(binarySearchTree.root, 40);
        binarySearchTree.root = binarySearchTree.insert(binarySearchTree.root, 70);
        binarySearchTree.root = binarySearchTree.insert(binarySearchTree.root, 60);
        binarySearchTree.root = binarySearchTree.insert(binarySearchTree.root, 80);

        System.out.println("Is 30 in BST? : " + binarySearchTree.search(binarySearchTree.root, 30));
        System.out.println("Is 80 in BST? : " + binarySearchTree.searchIteratively(binarySearchTree.root, 90));

        binarySearchTree.inorder(binarySearchTree.root);
        System.out.println("Deleting node 30");
        binarySearchTree.deleteNode(binarySearchTree.root, 30);
        binarySearchTree.inorder(binarySearchTree.root);
    }
}
