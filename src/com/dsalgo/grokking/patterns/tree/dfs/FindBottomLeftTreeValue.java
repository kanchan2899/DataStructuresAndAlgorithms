package com.dsalgo.grokking.patterns.tree.dfs;

// https://leetcode.com/problems/find-bottom-left-tree-value/
public class FindBottomLeftTreeValue {
    int maxDepth = 0;
    int val = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return val;
    }

    public void dfs(TreeNode root, int depth) {
        if(root != null) {
            if(depth > maxDepth) {
                val = root.val;
                maxDepth = depth;
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
