package com.dsalgo.trees;

// https://www.geeksforgeeks.org/connect-nodes-at-same-level/

import java.util.LinkedList;
import java.util.Queue;

class NodeWithNextRight {
    int data;
    NodeWithNextRight left, right, nextRight;

    NodeWithNextRight(int d) {
        data = d;
        left = right = nextRight = null;
    }
}
public class ConnectNodesAtSameLevel {

    NodeWithNextRight root;

    /**
     * Using BFS: Traverse the tree using Breadth first search traversal and maintain a prev
     * pointer initialized with NULL, firstly point it to root then every time a new node is
     * traversed set prev’s nextRight to current node  and move prev to prev’s next.
     *
     * 1. Initialize a node pointer Prev to NULL and a queue of node pointer Q.
     * 2. Traverse the tree in Breadth-first search order starting from the root.
     *      a. Calculate the size sz of the Q and run a for loop from 0 to sz – 1.
     *          - If prev is Null then set prev to the current node.
     *          - Else set prev’s next to the current node and prev to the current node.
     *      b. Set prev’s next to Null and prev to Null.
     *      c. If the current node’s left is not null push it into the queue.
     *      d. If the current node’s right is not null push it into the queue.
     *
     * @param root
     */
    void connectNodes(NodeWithNextRight root) {
        Queue<NodeWithNextRight> queue = new LinkedList<>();

        queue.add(root);

        NodeWithNextRight temp = null;

        while (!queue.isEmpty()) {
            int n = queue.size();

            for(int i = 0; i < n; i++) {
                NodeWithNextRight prev = temp;
                temp = queue.poll();

                if(i > 0) {
                    prev.nextRight = temp;
                }

                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }

            temp.nextRight = null;
        }
    }
    public static void main(String[] args) {
        ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();

        tree.root = new NodeWithNextRight(1);
        tree.root.left = new NodeWithNextRight(2);
        tree.root.right = new NodeWithNextRight(3);

        tree.connectNodes(tree.root);

    }
}
