package com.dsalgo.trees.binary.search;

// https://www.geeksforgeeks.org/find-closest-element-binary-search-tree/
public class ClosestElementInBST extends BinarySearchTree{
    Node root;
    public static void main(String[] args) {
        ClosestElementInBST tree = new ClosestElementInBST();
        tree.insert(null, 10);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 11);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 4);

        System.out.println(tree.minDiff(tree.root, 13));
//        System.out.println(tree.minDiffRecursive(tree.root, 13));
    }

    int min = Integer.MAX_VALUE;
    int minDiffRecursive(Node root, int k) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        minDiffRecursive(root.left, k);
        minDiffRecursive(root.right, k);

        if(Math.abs(root.data - k) < min) {
            min = Math.abs(root.data - k);
        }
        return min;
    }

    /**
     * Iterative solution:
     * @param root
     * @param K
     * @return
     */
    int minDiff(Node  root, int K)
    {
        int min = Integer.MAX_VALUE;
        while(root != null) {
            int diff = Math.abs(root.data - K);

            if(diff < min) {
                min = diff;
            }

            if(min == 0) {
                break;
            }

            if(root.data > K) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return min;
    }
}
