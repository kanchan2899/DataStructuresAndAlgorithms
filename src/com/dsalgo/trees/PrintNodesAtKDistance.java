package com.dsalgo.trees;

import java.util.HashSet;

public class PrintNodesAtKDistance {
    Node root;
   static void printKDistance(Node root, int k) {
        if(root == null) {
            return;
        }
        if(k == 0) {
            System.out.print(root.data + " ");
        }
        else {
            printKDistance(root.left, k - 1);
            printKDistance(root.right, k - 1);
        }
    }

    static HashSet<Integer> distinctNodesAtKDistance(Node root, int k) {
       if(root == null) {
           HashSet<Integer> uniqueNode = new HashSet<>();
           return uniqueNode;
       }

       HashSet<Integer> uniqueNodes = new HashSet<>();
       if(k == 0) {
           uniqueNodes.add(root.data);
           return uniqueNodes;
       }
       uniqueNodes.addAll(distinctNodesAtKDistance(root.left, k - 1));
       uniqueNodes.addAll(distinctNodesAtKDistance(root.right, k - 1));

       return uniqueNodes;
    }

    public static void main(String[] args) {
        PrintNodesAtKDistance tree = new PrintNodesAtKDistance();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        int k = 2;

        printKDistance(tree.root, k);
        System.out.println();
        System.out.println(distinctNodesAtKDistance(tree.root, k).size());
    }
}
