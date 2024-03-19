package com.dsalgo.grokking.patterns.tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        // if the root is null, return an empty list
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> rightView = new ArrayList<>();

        dfs(root, 0, rightView);

        return rightView;
    }

    private static void dfs(TreeNode node, int level, List<Integer> rightView) {
        // check if the level is equal to the rightView.size()
        if(level == rightView.size()) {
            rightView.add(node.val);
        }

        // create a list of child nodes(right, left)
        List<TreeNode> children = new ArrayList<>();
        children.add(node.right);
        children.add(node.left);

        // iterate through the child nodes
        for(TreeNode child: children) {
            if(child != null) {
                // recursively call the dfs on the child node
                dfs(child, level + 1, rightView);
            }
        }
    }
}
