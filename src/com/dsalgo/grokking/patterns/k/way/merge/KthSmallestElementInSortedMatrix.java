package com.dsalgo.grokking.patterns.k.way.merge;

import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array/
public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {5, 6, 7}, {8, 9, 10}};
        int k = 6;

        System.out.println(kthSmallest(arr, k));
    }

    private static int kthSmallest(int[][] arr, int k) {
        int rowCount = arr.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i = 0; i < rowCount; i++) {
            // push the first element of each row in the min-heap
            minHeap.offer(new int[]{arr[i][0], i, 0});
        }

        int numbersChecked = 0;
        int smallestElement = 0;

        // iterating over the elements pushed in the min-heap
        while (!minHeap.isEmpty()) {
            // get the smallest number from the top of the min-heap and its corresponding row and colum
            int[] current = minHeap.poll();
            smallestElement = current[0];
            int rowIndex = current[1];
            int colIndex = current[2];

            numbersChecked++;

            // when numbersChecked equals k, we'll return smallestElement
            if(numbersChecked == k) {
                break;
            }

            // if the current element has a next element in its row, add the next element of that
            // row to the min-heap
            if(colIndex + 1 < arr[rowIndex].length) {
                minHeap.offer(new int[] {arr[rowIndex][colIndex + 1], rowIndex, colIndex + 1});
            }
        }
        // return the kth smallest number
        return smallestElement;
    }
}
