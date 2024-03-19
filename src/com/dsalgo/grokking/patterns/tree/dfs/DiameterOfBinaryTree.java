package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    class Pair {
        int diameter;
        int height;

        public Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    /**
     * 1. Start with the assumption that the diameter is 0
     * 2. Calculate the diameter of the left sub-tree and right sub-tree of the root node using the
     * following recursive process:
     *   - At a leaf node, the diameter and height with respect to its children is 0 and 1, respectively.
     *   - For a non-leaf node, calculate the heights as well as the diameters of the left and right
     *      sub-trees. If the diameter passes through this node, then the diameter is the sum of the
     *      heights of the two sub-trees. Otherwise, it is the greater of the diameters of the two sub-trees.
     * 3. Update the diameter as the greater of two values:
     *      - the sum of the heights of the left and right sub-trees,
     *      - the greater of the diameters of the two sub-trees.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    public int diameter1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // calculate the Pair for the entire tree
        Pair pair = helper(root);

        // return the diameter from the pair
        return pair.diameter;
    }

    private Pair helper(TreeNode node) {
        if(node == null) {
            return new Pair(0, 0);
        } else {
            Pair left = helper(node.left);
            Pair right = helper(node.right);

            // calculate the height as the maximum height of left and right subtrees + 1
            int height = Math.max(left.height, right.height) + 1;

            // calculate the diameter as the maximum of left diameter, right diameter and the sum
            // of left and right heights
            int diameter = Math.max(left.diameter,
                    Math.max(right.diameter, left.diameter + right.diameter));

            return new Pair(diameter, height);
        }
    }

    int d = 0;
    public int diameter(TreeNode node) {
        height(node);
        return d;
    }

    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        d = Math.max(left, right);

        return 1 + Math.max(d, left + right);
    }

}
