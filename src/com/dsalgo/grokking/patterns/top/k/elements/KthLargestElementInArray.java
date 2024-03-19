package com.dsalgo.grokking.patterns.top.k.elements;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 12, 2, 11, 9, 7, 30, 20};
        int k = 3;

        System.out.println(kthLargestElementInArray(arr, k));
    }

    private static int kthLargestElementInArray(int[] arr, int k) {
        PriorityQueue<Integer> kNumbersMinHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        // add first k elements into the heap
        for(int i = 0; i < k; i++) {
            kNumbersMinHeap.add(arr[i]);
        }

        // loop through the remaining elements in the array
        for(int i = k ; i < arr.length; i++) {
            // compare the current element with the minimum element of the min-heap
            if(arr[i] > kNumbersMinHeap.peek()) {
                // remove the smallest element
                kNumbersMinHeap.poll();

                // add the current element
                kNumbersMinHeap.add(arr[i]);
            }
        }
        return (int) kNumbersMinHeap.peek();
    }
}
