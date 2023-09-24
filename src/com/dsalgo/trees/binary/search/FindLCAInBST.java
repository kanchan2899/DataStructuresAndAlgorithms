package com.dsalgo.trees.binary.search;

// https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
public class FindLCAInBST {
    Node root;
    Node lca(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        // if both n1 and n2 are smaller than root, then LCA lies in the left subtree
        if(root.data > n1 && root.data > n2) {
            return lca(root.left, n1, n2);
        }

        // if both n1 and n2 are greater than root, then LCA lies in the right subtree
        if(root.data < n1 && root.data < n2) {
            return lca(root.right, n1, n2);
        }

        return root;
    }

    public static void main(String[] args) {
        FindLCAInBST tree = new FindLCAInBST();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;

        System.out.println(tree.lca(tree.root, n1, n2).data);
    }
}
