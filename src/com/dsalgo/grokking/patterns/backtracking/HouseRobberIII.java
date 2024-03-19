package com.dsalgo.grokking.patterns.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HouseRobberIII {

    static class BinaryTree<T> {
        TreeNode<T> root;

        BinaryTree(List<TreeNode<T>> ListOfNodes) {
            root = createBinaryTree(ListOfNodes);
        }

        private TreeNode<T> createBinaryTree(List<TreeNode<T>> ListOfNodes) {
            if (ListOfNodes.isEmpty()) {
                return null;
            }

            // Create the root node of the binary tree
            TreeNode<T> root = new TreeNode<>(ListOfNodes.get(0).data);

            // Create a queue and add the root node to it
            Queue<TreeNode<T>> q = new LinkedList<>();
            q.add(root);

            // Start iterating over the list of ListOfNodes starting from the second node
            int i = 1;
            while (i < ListOfNodes.size()) {
                // Get the next node from the queue
                TreeNode<T> curr = q.remove();

                // If the node is not null, create a new TreeNode object for its left child,
                // set it as the left child of the current node, and add it to the queue
                if (ListOfNodes.get(i) != null) {
                    curr.left = new TreeNode<>(ListOfNodes.get(i).data);
                    q.add(curr.left);
                }

                i++;

                // If there are more ListOfNodes in the list and the next node is not null,
                // create a new TreeNode object for its right child, set it as the right child
                // of the current node, and add it to the queue
                if (i < ListOfNodes.size() && ListOfNodes.get(i) != null) {
                    curr.right = new TreeNode<>(ListOfNodes.get(i).data);
                    q.add(curr.right);
                }

                i++;
            }

            // Return the root of the binary tree
            return root;
        }
    }
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        List<TreeNode<Integer>> tree = Arrays.asList(new TreeNode<>(10), new TreeNode<>(9),
                new TreeNode<>(20), new TreeNode<>(15), new TreeNode<>(7));
        BinaryTree<Integer> binaryTree = new BinaryTree<>(tree);
        System.out.println(rob(binaryTree.root));
    }

    private static int rob(TreeNode<Integer> root) {
        // returns maximum value from the pari: [includeRoot, excludeRoot]
        int[] result = heist(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] heist(TreeNode<Integer> root) {
        // base case
        if(root == null) {
            return new int[]{0, 0};
        }
        // recursively calculate the maximum amount that can be robbed from the left subtree of the root
        int[] leftSubtree = heist(root.left);
        // recursively calculate the maximum amount that can ve robbed from the right subtree of the root
        int[] rightSubtree = heist(root.right);

        // includeRoot contains the maximum amount of money that can be robbed with the parent node included
        int includeRoot = root.data + leftSubtree[1] + rightSubtree[1];

        // excludeRoot contains the maximum amount of money that can be robbed with the parent node excluded
        int excludeRoot = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);

        return new int[] {includeRoot, excludeRoot};
    }
}
