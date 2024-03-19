package com.dsalgo.grokking.patterns.top.k.elements;

import com.dsalgo.heap.KthLargestElement;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    PriorityQueue<Integer> topKHeap;
    int k;

    public KthLargestElementInStream(int k, int[] arr) {
        this.k = k;
        topKHeap = new PriorityQueue<>();
        int kth = 0;

        for(int element: arr) {
           kth  = add(element);
        }
        System.out.println(kth);
    }

    // adds element in the heap and return the Kth largest
    private int add(int element) {
        if(topKHeap.size() < k) {
            topKHeap.offer(element);
        } else if (element > topKHeap.peek()) {
            topKHeap.poll();
            topKHeap.offer(element);
        }
        return topKHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 10};
        int k = 3;
        KthLargestElementInStream kthLargestElementInStream = new KthLargestElementInStream(k, arr);
    }
}
