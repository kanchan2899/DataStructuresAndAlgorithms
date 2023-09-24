package com.dsalgo.trees.binary.search;

import java.util.*;

// https://www.geeksforgeeks.org/construct-bst-given-level-order-traversal/
public class ConvertLevelOrderToBST extends BinarySearchTree {
    Node root;
    private Node levelOrder(Node root, Integer data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data <= root.data) {
            root.left = levelOrder(root.left, data);
        } else {
            root.right = levelOrder(root.right, data);
        }
        return root;
    }

    /**
     * Using recursion: the first element will always be the root of the tree and second element will
     * be the left child and the third element will be the right child
     * (if fall in the range), and so on for all the remaining elements.
     *
     * 1. First, pick the first element of the array and make it root.
     * 2. Pick the second element, if its value is smaller than the root node value make it
     * left child,
     * 3. Else make it right child
     * 4. Now recursively call step (2) and step (3) to make a BST from its level Order Traversal.
     * @param levelOrder
     * @return
     */
    Node constructBST(List<Integer> levelOrder) {
        if(levelOrder.size() == 0) {
            return null;
        }
        Node root = null;

        for(int i = 0; i < levelOrder.size(); i++) {
            root = levelOrder(root, levelOrder.get(i));
        }

        return root;
    }


    /**
     *
     *  Using Level Order traversal: In this case, we maintain a queue that contains a pair
     *  of the Node class and an integer pair storing the range for each of the tree nodes.
     *
     * TC: O(n)
     * SC: O(n)
     * @param levelOrder
     * @return
     */
    Node constructBST1(List<Integer> levelOrder) {
        if(levelOrder.size() == 0) {
            return null;
        }

        Node root = new Node(levelOrder.get(0));
        Node head = root;

        Queue<NodeRange> queue = new LinkedList<>();

        queue.add(new NodeRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        for(int i = 1; i < levelOrder.size(); i++) {
            NodeRange curr = queue.peek();

            // check if ith node can be a child of the current node
            if(levelOrder.get(i) > curr.min && levelOrder.get(i) < curr.max) {
                if(levelOrder.get(i) < curr.node.data) {
                    curr.node.left = new Node(levelOrder.get(i));
                    queue.add(new NodeRange(curr.node.left, curr.min, curr.node.data));
                }
                // check if current node can be the right child
                else {
                    queue.remove();
                    curr.node.right = new Node(levelOrder.get(i));
                    queue.add(new NodeRange(curr.node.right, curr.node.data, curr.max));
                }
            } else {
                queue.remove();
                i--;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        List<Integer> levelOrder = Arrays.asList(7, 4, 12, 3, 6, 8, 1, 5, 10);
        ConvertLevelOrderToBST tree = new ConvertLevelOrderToBST();
        tree.root = tree.constructBST(levelOrder);
        tree.inorder(tree.root);

        tree.root = tree.constructBST1(levelOrder);
        tree.inorder(tree.root);
    }

}

class NodeRange {
    Node node;
    int min, max;

    NodeRange(Node node, int min, int max) {
        this.node = node;
        this.min = min;
        this.max = max;
    }
}
