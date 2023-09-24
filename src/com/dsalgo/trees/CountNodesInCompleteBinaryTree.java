package com.dsalgo.trees;

// https://www.geeksforgeeks.org/count-number-of-nodes-in-a-complete-binary-tree/
public class CountNodesInCompleteBinaryTree {
    Node root;

    /**
     * Bruteforce: Traverse the tree and increment the count for every non-null nodes
     *
     * TC: O(n)
     * SC: O(height)
     * @param root
     * @return
     */
    int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * Efficient approach: A complete binary tree can have at most (2h + 1 – 1) nodes in total
     * where h is the height of the tree (This happens when all the levels are completely filled).
     *
     * TC: O(log n * log n)
     * SC: O(log n)
     *
     * @param root
     * @return
     */
    int countNodes1(Node root) {
        int lh = 0, rh = 0;
        Node current = root;

        while (current != null) {
            lh++;
            current = current.left;
        }

        current = root;

        while (current != null) {
            rh++;
            current = current.right;
        }

        if(lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }

        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    public static void main(String[] args) {
        CountNodesInCompleteBinaryTree tree = new CountNodesInCompleteBinaryTree();

        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(14);
        tree.root.left.left.left = new Node(13);

        System.out.println("Nodes in complete binary tree using naive approach is " +
                tree.countNodes(tree.root));
        System.out.println("Nodes in complete binary tree using efficient approach is " +
                tree.countNodes1(tree.root));
    }
}
