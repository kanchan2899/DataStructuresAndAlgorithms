package com.dsalgo.heap;

import java.util.*;

// https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        int k = 3;

        System.out.println(kLargest(arr, k));
        System.out.println(kLargest1(arr, k));
        System.out.println(kLargest2(arr, k));
    }

    /**
     * Using max heap:
     *
     * 1) Build a Max Heap tree in O(n)
     * 2) Use Extract Max k times to get k maximum elements from the Max Heap O(k*log(n))
     *
     * TC: O(n + k * log n)
     * SC: O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    private static List<Integer> kLargest1(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> kLargestElements = new ArrayList<>();
        for(int i : arr) {
            pq.offer(i);
        }

        for(int i = 0; i < k; i++) {
            kLargestElements.add(pq.poll());
        }
        return kLargestElements;
    }

    /**
     * Using min heap:
     *
     *
     * 1. Initialize a min heap (priority queue) pq.
     * 2. For each element in the array:
     *      a. Push the element onto the max heap.
     *      b. If the size of the max heap exceeds K, pop (remove) the smallest element
     *      from the min heap. This step ensures that the min heap maintains the K largest
     *      elements encountered so far.
     * 3. After processing all elements, the min heap will contain the K largest elements of
     * the array.
     *
     * TC: O((n-k) * k * log n)
     * SC: O(k)
     *
     * @param arr
     * @param k
     * @return
     */
    private static List<Integer> kLargest2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> kLargestElements = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        for(int i = k; i < arr.length; i++) {
            if(pq.peek() > arr[i]) {
                continue;
            } else {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        kLargestElements.addAll(pq);

        return kLargestElements;
    }

    /**
     * Using sorting:
     *
     * 1) Sort the elements in descending order in O(n*log(n))
     * 2) Return the first k numbers of the sorted array O(k).
     *
     * TC: O(n * log n)
     * SC: O(k)
     *
     * @param arr
     * @param k
     * @return
     */
    private static List<Integer> kLargest(int[] arr, int k) {
        List<Integer> kLargestElements = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = arr.length - 1; i > arr.length - k - 1; i--) {
            kLargestElements.add(arr[i]);
        }
        return kLargestElements;
    }
}
