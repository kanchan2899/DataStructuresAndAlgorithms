package com.dsalgo.trees;

// https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
public class MaximumPathSum {
    Node root;

    /**
     *
     * check 4 paths: For each node there can be four ways that the max path goes through the node:
     *
     * 1. Node only
     * 2. Max path through Left Child + Node
     * 3. Max path through Right Child + Node
     * 4. Max path through Left Child + Node + Max path through Right Child
     *
     *
     * 1. If the root is NULL, return 0(Base Case)
     * 2. Call the recursive function to find the max sum for the left and the right subtree
     * 3. In a variable store the maximum of (root->data, maximum of (leftSum, rightSum) + root->data)
     * 4. In another variable store the maximum of previous step and root->data + leftSum + rightSum
     * 5. Return the maximum of the previous step
     * @return
     */
     class Res {
        int val;
    }
    int helper(Node root, Res res) {
        if(root == null) {
            return 0;
        }

        // l and r store maximum path sum going through left and right child of root respectively
        int l = helper(root.left, res);
        int r = helper(root.right, res);

        // Max path for parent call of root. This path must include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + root.data, root.data);

        // Max Top represents the sum when the Node under consideration is the root of the
        // maxsum path and no ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + root.data);

        res.val = Math.max(res.val, max_top);

        return max_single;
    }

    int findMaxSum(Node root) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        helper(root, res);
        return res.val;
    }

    public static void main(String[] args) {
        MaximumPathSum tree = new MaximumPathSum();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println(tree.findMaxSum(tree.root));

    }
}
