package com.dsalgo.heap;

import java.util.*;

// https://www.geeksforgeeks.org/merge-k-sorted-arrays/
public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
        int k = 3;

        System.out.println(mergeKSortedArrays(arr, k));
        System.out.println(mergeKSortedArrays1(arr, k));
    }

    /**
     * Using heap:
     *
     * 1. Create a min-heap of size k and insert 1st element in all the arrays into the heap
     * 2. Repeat the following steps while the priority queue is not empty.
     * .....a) Remove the minimum element from the heap (minimum is always at the root) and
     * store it in the output array.
     * .....b) Insert the next element from the array from which the element is extracted.
     * If the array doesn’t have any more elements, then do nothing.
     *
     * TC: O(n * log k)
     * SC: O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    private static ArrayList<Integer> mergeKSortedArrays1(int[][] arr, int k) {
        ArrayList<Integer> mergedArrays = new ArrayList<>();
        PriorityQueue<HeapNode> heapNodes = new PriorityQueue<HeapNode>();

        // initially add only first column of elements.
        for(int i = 0; i < arr.length; i++) {
            heapNodes.add(new HeapNode(i, 0, arr[i][0]));
        }

        HeapNode curr = null;

        while (!heapNodes.isEmpty()) {
            curr = heapNodes.poll();
            mergedArrays.add(curr.value);

            // check if next element of curr min exists, then add that to heap
            if(curr.y < (arr[curr.x].length - 1)) {
                heapNodes.add(new HeapNode(curr.x, curr.y + 1, arr[curr.x][curr.y + 1]));
            }
        }
        return mergedArrays;
    }


    /**
     * Naive Approach: Create an output array of size (N * K) and then copy all the elements
     * into the output array followed by sorting.
     *
     * TC: O(n * k * log (n * k))
     * SC: O(n * k)
     *
     * @param arr
     * @param k
     * @return
     */
    private static List<Integer> mergeKSortedArrays(int[][] arr, int k) {
        List<Integer> array = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                array.add(arr[i][j]);
            }
        }
        Collections.sort(array);
        return array;
    }



}
