package com.dsalgo.trees.binary.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

// https://www.geeksforgeeks.org/find-pair-given-sum-bst/
public class PairSumInBST extends BinarySearchTree{

    /**
     * Using inorder traversal and hashing: We traverse binary search tree by inorder way and
     * insert node’s value into a set. Also check for any node, difference between given sum and
     * node’s value in set, if it is found then pair exists otherwise it doesn’t exist.
     *
     *
     * 1. Traverse the tree, while traversing store the value of a node in the set
     * 2. If for a current node with value x, there exists a y for which x + y = sum then check
     * it using set and return the pair.
     * @param root
     * @param sum
     * @return
     */
    boolean findPair(Node root, int sum) {
        return helper(root, sum, new HashSet<Integer>());
    }

    private boolean helper(Node root, int sum, HashSet<Integer> set) {
        if(root == null) {
            return false;
        }
        if(helper(root.left, sum, set)) {
            return true;
        }

        if(set.contains(sum - root.data)) {
            return true;
        }
        else {
            set.add(root.data);
        }
        return helper(root.right, sum, set);
    }

    /**
     * Using inorder traversal and two pointers approach: Store inorder traversal in an array. Now use
     * two pointers approach to find a pair
     *
     * 1. First find the Inorder traversal of the Given BST and store it in an array v
     * 2. Take two pointers i and j. Keep i at the start of v and j at the end of the v.
     *   a. Now, if sum of elements at the ith index and jth index is greater that the given element
     *   then decrement j,
     *   b. if sum of elements at the ith index and jth index is less that the given element then
     *   increment i,
     *   c. else, these two elements are our required answer.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @param sum
     * @return
     */
    boolean findPair1(Node root, int sum) {
        ArrayList<Integer> traversal = new ArrayList<>();
        inorder1(root, traversal);
        int i = 0, j = traversal.size() - 1;

        while (i < j) {
            int start = traversal.get(i);
            int end = traversal.get(j);
            if(start + end == sum) {
                return true;
            } else if(start + end > sum) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    void inorder1(Node root, ArrayList<Integer> traversal) {
        if(root != null) {
            inorder(root.left);
            traversal.add(root.data);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        PairSumInBST tree = new PairSumInBST();

        tree.root = tree.insert(null, 5);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 9);

        System.out.println(tree.findPair(tree.root, 11));
        System.out.println(tree.findPair1(tree.root, 16));
    }
}
