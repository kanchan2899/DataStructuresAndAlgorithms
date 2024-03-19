package com.dsalgo.grokking.patterns.tree.dfs;

public class ConvertSortedArrayToBST {
    public static TreeNode sortedArrayBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int low, int high) {
        // base case; if low > high, there is no elements to add in the BST
        if(low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        // center value of the sorted array as the root of the BSt
        TreeNode root = new TreeNode(nums[mid]);

        // recursively add the elements in nums[low : mid - 1] to the left subtree of root
        root.left = helper(nums, low, mid - 1);

        // recursively add the elements in nums[mid + 1 : high] to the right subtree of root
        root.right = helper(nums, mid + 1, high);

        return root;
    }
}
