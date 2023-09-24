package com.dsalgo.trees;

// https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
public class IsSubtree {
    Node root;

    static boolean areIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }

        // check if data of both roots is same and data of left and right subtrees are same
        return (root1.data == root2.data &&
                areIdentical(root1.left, root2.left) &&
                areIdentical(root1.right, root2.right));
    }

    static boolean isSubtree(Node t, Node s) {
        if(s == null) {
            return true;
        }
        if(t == null) {
            return false;
        }

        if(areIdentical(t, s)) {
            return true;
        }

        return (isSubtree(t.left, s) || isSubtree(t.right, s));
    }

    public static void main(String[] args) {
        IsSubtree tree = new IsSubtree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        IsSubtree subtree = new IsSubtree();
        subtree.root = new Node(3);
        subtree.root.left = new Node(6);
        subtree.root.right = new Node(7);

        System.out.println("Is subtree? " + isSubtree(tree.root, subtree.root));

    }
}
