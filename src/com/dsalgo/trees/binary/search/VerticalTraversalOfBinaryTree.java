package com.dsalgo.trees.binary.search;

import java.util.*;

// https://www.geeksforgeeks.org/vertical-order-traversal-of-binary-tree-using-map/
public class VerticalTraversalOfBinaryTree {
    Node root;

    /**
     * Using self-balancing binary tree and unordered map:
     *
     * 1. Create a queue of pair to store the node and its horizontal distance in the tree
     * 2. Create a map to store the value of nodes at each horizontal distance
     * 3. Now perform a BFS on the tree
     * 4. At each iteration store the nodes with a particular horizontal distance in the map
     * 5. Push the left and the right child of the tree with horizontal distance – 1 and
     * horizontal distance + 1 into the queue
     * 6. Print the answer using map
     *
     * TC: O(
     * @param root
     * @return
     */
    ArrayList<Integer> verticalTraversal(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<Integer> traversal = new ArrayList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node current = p.node;
            int hd = p.hd;

            if(map.containsKey(hd)) {
                map.get(hd).add(current.data);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(current.data);
                map.put(hd, list);
            }

            if(current.left != null) {
                queue.add(new Pair(current.left, hd-1));
            }
            if(current.right != null) {
                queue.add(new Pair(current.right, hd+1));
            }
        }

        map.forEach((key, value) -> {
            traversal.addAll(value);
        });

        return traversal;
    }

    public static void main(String[] args) {
        VerticalTraversalOfBinaryTree tree = new VerticalTraversalOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println(tree.verticalTraversal(tree.root));
    }
}

class Pair {
    Node node;
    int hd;

    Pair(Node n, int hd) {
        node = n;
        this.hd = hd;
    }
}