package com.dsalgo.greedy;

import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
public class HuffmanCoding {
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char c, int f, Node l, Node r) {
            ch = c;
            freq = f;
            left = l;
            right = r;
        }
    }

    /**
     * Build Huffman Tree:
     * 1. Create a leaf node for each unique character and build a min heap of all leaf nodes
     * (Min Heap is used as a priority queue. The value of frequency field is used to compare
     * two nodes in min heap. Initially, the least frequent character is at root)
     * 2. Extract two nodes with the minimum frequency from the min heap.
     * 3. Create a new internal node with a frequency equal to the sum of the two nodes frequencies.
     * Make the first extracted node as its left child and the other extracted node as its right
     * child. Add this node to the min heap.
     * 4. Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the
     * root node and the tree is complete.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param arr
     * @param freq
     */
    static void printHuffmanCodes(char[] arr, int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.freq - n2.freq);

        for(int i = 0; i < arr.length; i++) {
            pq.add(new Node(arr[i], freq[i], null, null));
        }

        while (pq.size() > 1) {
            Node l = pq.poll();
            Node r = pq.poll();

            pq.add(new Node('$', l.freq + r.freq, l, r));
        }

        printCodes(pq.peek(), "");
    }

    /**
     *
     * Traverse Huffman tree to get the codes: Preorder traversal
     *
     * TC: O(n)
     * SC: O(n) - recursion
     * @param root
     * @param s
     */
    private static void printCodes(Node root, String s) {
        if(root.ch != '$') {
            System.out.println(root.ch + " " + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void main(String[] args) {
        char[] ch = {'a', 'b', 'c', 'd', 'e'};
        int[] freq = {10, 20, 40, 50, 80};

        printHuffmanCodes(ch, freq);
    }
}
