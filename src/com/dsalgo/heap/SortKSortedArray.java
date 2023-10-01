package com.dsalgo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/nearly-sorted-algorithm/
public class SortKSortedArray {

    /**
     * Using Priority Queue:
     * 1) Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time.
     * We are creating heap of size k as the element can be atmost k distance from its index
     * in a sorted array.
     * 2) One by one remove min element from heap, put it in result array, and add a new element
     * to heap from remaining elements.
     *
     * Removing an element and adding a new element to min heap will take log k time.
     * So overall complexity will be O(k) + O((n-k) * log(k)).
     *
     * TC: O(k) + O((m) * log(k)), where m = n - k
     * SC: O(k)
     *
     * @param arr
     * @param k
     */
    static void sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        int index = 0;

        for(int i = k + 1; i < arr.length; i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 18, 17, 19};
        int k = 2;

        sortKSortedArray(arr, k);

        System.out.println(Arrays.toString(arr));

    }
}
