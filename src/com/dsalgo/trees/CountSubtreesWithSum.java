package com.dsalgo.trees;

// https://www.geeksforgeeks.org/count-subtress-sum-given-value-x/
public class CountSubtreesWithSum {
    Node root;

    int count = 0;

    /**
     * Call left and right subtree recursively to calculate the current sum. If it is equal to the sum,
     * update the count
     *
     * TC: O(n)
     * SC: O(height)
     *
     * @param root
     * @param sum
     * @return
     */
    int countSubtreesWithSum(Node root, int sum) {
        helper(root, sum);
        return count;
    }

    int helper(Node root, int sum) {
        if(root == null) {
            return 0;
        }

        int curr_sum = helper(root.left, sum) + helper(root.right, sum) + root.data;

        if(curr_sum == sum) {
            count++;
        }
        return curr_sum;
    }

    public static void main(String[] args) {
        CountSubtreesWithSum tree = new CountSubtreesWithSum();

        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.right = new Node(7);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);

        System.out.println(tree.countSubtreesWithSum(tree.root, 11));
    }
}
