package com.dsalgo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
public class KthLargestElement {

    static int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};

        System.out.println(kthLargest(arr, 4));
    }
}
