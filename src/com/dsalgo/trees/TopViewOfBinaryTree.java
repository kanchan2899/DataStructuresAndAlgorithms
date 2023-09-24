package com.dsalgo.trees;

// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

import java.util.*;

class NodeWithHorizontalDistance {
    Node node;
    int hd;
    NodeWithHorizontalDistance(Node n, int hd) {
        this.node = n;
        this.hd = hd;
    }
}
public class TopViewOfBinaryTree {
    Node root;

    void topView(Node root) {
        Queue<NodeWithHorizontalDistance> queue = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();

        if(root == null) {
            return;
        }

        queue.add(new NodeWithHorizontalDistance(root, 0));

        while (!queue.isEmpty()) {
            NodeWithHorizontalDistance current = queue.poll();
            if(!map.containsKey(current.hd)) {
                map.put(current.hd, current.node);
            }

            if(current.node.left != null) {
                queue.add(new NodeWithHorizontalDistance(current.node.left, current.hd - 1));
            }
            if(current.node.right != null) {
                queue.add(new NodeWithHorizontalDistance(current.node.right, current.hd + 1));
            }
        }

        map.forEach((key, value) -> {
            System.out.print(value.data + " ");
        });
    }

    public static void main(String[] args) {
        TopViewOfBinaryTree tree = new TopViewOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);

        tree.topView(tree.root);
    }

}
