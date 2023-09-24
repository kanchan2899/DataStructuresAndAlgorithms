package com.dsalgo.trees.binary.search;

import java.util.Map;
import java.util.TreeMap;

// https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
public class VerticalSumInBinaryTree {
    Node root;

    /**
     * We need to check the Horizontal Distances from the root for all nodes. If two nodes have
     * the same Horizontal Distance (HD), then they are on the same vertical line. The idea of
     * HD is simple. HD for root is 0, a right edge (edge connecting to right subtree) is considered
     * as +1 horizontal distance and a left edge is considered as -1 horizontal distance.
     * For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and
     * 6 is 0 and HD for node 7 is +2.
     *
     * We can do an in-order traversal of the given Binary Tree. While traversing the tree,
     * we can recursively calculate HDs. We initially pass the horizontal distance as 0 for root.
     * For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1.
     * For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1.
     *
     *
     * TC: O(n * log hd)
     * SC: O(hd)
     * @param root
     */
    void verticalSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        helper(root, 0, map);

        for(Map.Entry sum : map.entrySet()) {
            System.out.print(sum.getValue() + " ");
        }
    }

    private void helper(Node root, int horizontalDistance, TreeMap<Integer, Integer> map) {
        if(root == null) {
            return;
        }
        helper(root.left, horizontalDistance - 1, map);
        int pSum = (map.get(horizontalDistance) == null) ? 0 : map.get(horizontalDistance);
        map.put(horizontalDistance, pSum + root.data);
        helper(root.right, horizontalDistance + 1, map);
    }

    public static void main(String[] args) {
        VerticalSumInBinaryTree tree = new VerticalSumInBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.verticalSum(tree.root);
    }
}
