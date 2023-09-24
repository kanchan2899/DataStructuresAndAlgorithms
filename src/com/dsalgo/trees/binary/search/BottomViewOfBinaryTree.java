package com.dsalgo.trees.binary.search;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class NodeWithHD {
    Node node;
    int hd;

    NodeWithHD(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
// https://www.geeksforgeeks.org/bottom-view-binary-tree/
public class BottomViewOfBinaryTree {
    Node root;

    void bottomView(Node root) {
        if(root == null) {
            return;
        }

        int hd = 0;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<NodeWithHD> queue = new LinkedList<>();

        queue.add(new NodeWithHD(root, 0));

        while (!queue.isEmpty()) {
            NodeWithHD current = queue.poll();

            int dist = current.hd;

            // put the dequeued node to map having key as hd, every time we find a node having the
            // same hd, we need to replace the current data in the map
            map.put(dist, current.node.data);

            if(current.node.left != null) {
                queue.add(new NodeWithHD(current.node.left, dist - 1));
            }
            if(current.node.right != null) {
                queue.add(new NodeWithHD(current.node.right, dist + 1));
            }
        }
        map.forEach((key, value) -> {
            System.out.print(value + " ");
        });
    }

    public static void main(String[] args) {
        BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        tree.bottomView(tree.root);
    }
}
