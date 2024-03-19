package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LowestCommonAncestorOfBinaryTree {
    private TreeNode lca = null;

    /**
     * 1. First, we initialize three tracking variables, mid, left, and right, to track whether
     * p or q has been found
     * 2. Then, we traverse the binary tree recursively using depth-first search starting
     * from the root node.
     * 3. If we find p or q during our traversal of the binary tree, we set the mid variable
     * to TRUE and return mid.
     * 4. The left tracking variable is used to store the result of the left subtree of the
     * current node, and right tracking variable is used to store the result of the right subtree
     * of the current node. So, the results from the recursive calls are stored in their respective
     * tracking variables.
     * 5. Finally, during the traversal of the binary tree, if any two of the tracking variables,
     * mid, left, or right, are TRUE, we set the current node as our answer node because this node
     * will be the lowest common ancestor of p and q.
     *
     * TC: O(n)
     * SC: O(h)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lcaHelper(root, p, q);
        return lca;
    }

    private boolean lcaHelper(TreeNode currentNode, TreeNode p, TreeNode q) {
        // if currentNode does not exist
        if(currentNode == null) {
            return false;
        }

        // initialize tracking variables
        boolean left = false, right = false, mid = false;

        // check if either of the input nodes is the currentNode
        if(p == currentNode || q == currentNode) {
            mid = true;
        }

        // traverse the binary tree using dfs
        left = lcaHelper(currentNode.left, p, q);

        // if the lowest common ancestor has not been found, only then traverse the right subtree
        if(lca == null) {
            right = lcaHelper(currentNode.right, p, q);
        }

        // if any two of the tracking variables are true, set currentNode as answer node
        if(boolToInt(mid) + boolToInt(left) + boolToInt(right) >= 2) {
            lca = currentNode;
        }

        // return true if any of the tracking variables is true
        return mid || left || right;
    }

    private int boolToInt(boolean val) {
        return (val) ? 1 : 0;
    }
}
