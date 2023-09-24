package com.dsalgo.trees.binary.search;

import java.util.ArrayList;
import java.util.Stack;

// https://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/
public class CommonNodes extends BinarySearchTree{

    Node root1, root2;
    void inorder(Node root, ArrayList<Integer> traversal) {
        if(root != null) {
            inorder(root.left, traversal);
            traversal.add(root.data);
            inorder(root.right, traversal);
        }
    }

    /**
     * Using inorder traversal: Take the inorder traversal of both the trees and store them in
     * two separate arrays and then find the intersection between two arrays.
     *
     * TC: O(m + n)
     * SC: O(m + n)
     *
     * @param root1
     * @param root2
     */
    ArrayList<Integer> printCommon(Node root1, Node root2) {
        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        ArrayList<Integer> commonNodes = new ArrayList<>();

        inorder(root1, inorder1);
        inorder(root2, inorder2);

        int i = 0, j = 0;

        while (i < inorder1.size() && j < inorder2.size()) {
            if(inorder1.get(i) == inorder2.get(j)) {
                commonNodes.add(inorder1.get(i));
                i++;
                j++;
            } else if(inorder1.get(i) < inorder2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return commonNodes;
    }


    /**
     * Iterative using stacks: Use two stacks and store inorder traversal of trees in respective
     * stacks but the maximum number of elements should be equal to that particular branch of the tree.
     *
     * 1. Create two stacks for two inorder traversals
     * 2. Push the Nodes of the first tree in stack s1, till that branch reaches NULL.
     * 3. Push the Nodes of the second tree in stack s2, till that branch reaches NULL
     * 4. If both branches reach NULL, then check
     *      a. If root1->data < root2->data,
     *      b. If node of the first tree is smaller than that of the second tree, then it is obvious
     *      that the inorder successors of the current node can have the same value as that of the
     *      second tree Node.
     *      c. Thus, we pop from s1.
     *
     * TC: O(m  + n)
     * SC: O(h1 + h2)
     *
     * @param root1
     * @param root2
     * @return
     */
    ArrayList<Integer> printCommon1(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        ArrayList<Integer> commonNodes = new ArrayList<>();

        while (true) {
            if(root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            } else if(root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            } else if(!stack1.isEmpty() && !stack2.isEmpty()) {
                root1 = stack1.peek();
                root2 = stack2.peek();

                if(root1.data == root2.data) {
                    commonNodes.add(root1.data);
                    stack1.pop();
                    stack2.pop();

                    // move to the inorder successor
                    root1 = root1.right;
                    root2 = root2.right;
                } else if(root1.data < root2.data) {
                    // if node of first tree is smaller than that of second tree, then its obvious
                    // that the inorder successors of current node can have same value as that of
                    // the second tree node, thus pop from stack1
                    stack1.pop();
                    root1 = root1.right;

                    // root2 is set to null because we need new nodes of tree1
                    root2 = null;
                } else if(root1.data > root2.data) {
                    stack2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }
            else {
                break;
            }
        }
        return commonNodes;
    }

    public static void main(String[] args) {
        CommonNodes tree = new CommonNodes();

        tree.root1 = tree.insert(null, 5);
        tree.root1 = tree.insert(tree.root1, 1);
        tree.root1 = tree.insert(tree.root1, 10);
        tree.root1 = tree.insert(tree.root1, 0);
        tree.root1 = tree.insert(tree.root1, 4);
        tree.root1 = tree.insert(tree.root1, 7);
        tree.root1 = tree.insert(tree.root1, 9);


        tree.root2 = tree.insert(null, 10);
        tree.root2 = tree.insert(tree.root2, 7);
        tree.root2 = tree.insert(tree.root2, 20);
        tree.root2 = tree.insert(tree.root2, 4);
        tree.root2 = tree.insert(tree.root2, 9);

        System.out.println(tree.printCommon(tree.root1, tree.root2));
        System.out.println(tree.printCommon1(tree.root1, tree.root2));

    }

}
