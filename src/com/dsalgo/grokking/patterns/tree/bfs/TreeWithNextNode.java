package com.dsalgo.grokking.patterns.tree.bfs;

public class TreeWithNextNode {
    int val;
    TreeWithNextNode left;
    TreeWithNextNode right;

    TreeWithNextNode next;

    TreeWithNextNode() {}
    TreeWithNextNode(int val) {
        this.val = val;
    }
    TreeWithNextNode(int val, TreeWithNextNode left, TreeWithNextNode right, TreeWithNextNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
