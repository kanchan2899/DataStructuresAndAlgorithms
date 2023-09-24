package com.dsalgo.trees;

public class IsTreeHeightBalanced {
    Node root;

    /**
     * Bruteforce: Get the height of left and right subtrees using dfs traversal.
     * Return true if the difference between heights is not more than 1 and left and right
     * subtrees are balanced, otherwise return false.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    static boolean isHeightBalances(Node root) {
        if(root == null) {
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh - rh) <= 1 && isHeightBalances(root.left) && isHeightBalances(root.right))
            return true;
        return false;
    }

    static int height(Node root) {
        if(root == null) {
            return 0;
        }
        return (1 + height(root.left) + height(root.right));
    }


    /**
     * Calculate the height in the same recursion rather than calling a height() function separately
     *
     * 1. For each node make two recursion calls – one for left subtree and the other for the
     * right subtree.
     * 2. Based on the heights returned from the recursion calls, decide if the subtree whose
     * root is the current node is height-balanced or not.
     * 3. If it is balanced then return the height of that subtree. Otherwise, return -1 to
     * denote that the subtree is not height-balanced.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @return
     */
    static boolean isHeightBalanced1(Node root) {
        if(helper(root) > 0) {
            return true;
        }
        return false;
    }

    private static int helper(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = helper(root.left);
        if(lh == -1) {
            return -1;
        }

        int rh = helper(root.right);
        if(rh == -1) {
            return -1;
        }

        if(Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }


    public static void main(String[] args) {
        IsTreeHeightBalanced tree = new IsTreeHeightBalanced();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Is tree height balanced using bruteforce approach? " +
                isHeightBalances(tree.root));

        System.out.println("Is tree height balanced using efficient approach? " +
                isHeightBalanced1(tree.root));
    }
}
