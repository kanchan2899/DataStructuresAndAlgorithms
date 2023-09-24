package com.dsalgo.trees;

import java.lang.reflect.Array;
import java.util.ArrayList;

// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class LowestLevelCommonAncestor {

    Node root;

    boolean findPath(Node root, ArrayList<Node> path, int n) {
        if(root == null) {
            return false;
        }
        path.add(root);
        if(root.data == n)
            return true;

        if(findPath(root.left, path, n) || findPath(root.right, path, n))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    /**
     *
     * Using path arrays:
     *
     * 1. Find the path from the root node to node n1 and store it in a vector or array.
     * 2. Find the path from the root node to node n2 and store it in another vector or array.
     * 3. Traverse both paths untill the values in arrays are same. Return the common element just
     * before the mismatch
     *
     * TC: O(n)
     * SC: O(height)
     *
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if(!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
            return null;
        }

        for(int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if(path1.get(i + 1) != path2.get(i + 1)) {
                return path1.get(i);
            }
        }
        return null;
    }

    /**
     * Efficient solution The idea is to traverse the tree starting from the root node.
     * If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming
     * that both keys are present). If root doesn't match with any of the keys, we recur
     * for left and right subtrees. The node which has one key present in its left subtree
     * and the other key present in the right subtree is the LCA. If both keys lie in left subtree,
     * then left subtree has LCA also, otherwise, LCA lies in the right subtree.
     *
     * TC: O(n)
     * SC: O(height)
     *
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    Node lca1(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            return root;
        }

        Node lca1 = lca1(root.left, n1, n2);
        Node lca2 = lca1(root.right, n1, n2);

        if(lca1 != null && lca2 != null) {
            return root;
        }

        if(lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }

    public static void main(String[] args) {
        LowestLevelCommonAncestor tree = new LowestLevelCommonAncestor();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(50);

        System.out.println(tree.lca(tree.root, 20, 50).data);
        System.out.println(tree.lca1(tree.root, 20, 50).data);
    }
}
