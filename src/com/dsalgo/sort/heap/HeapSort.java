package com.dsalgo.sort.heap;

import java.util.Arrays;

// https://geeksforgeeks.org/heap-sort/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 9, 10, 8, 6, 7, 5};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * Heap sort: This is a comparison-based sorting technique based on binary heap data structure.
     * It is similar to selection sort where we first find the minimum element and place the minimum
     * element at the beginning. Repeat the same process for the remaining elements. It is an in-place
     * sorting algo and typically not a stable sorting algo. It is typically 2-3 times slower than the
     * quick sort algo because of lack of locality of reference.
     *
     *
     * Algorithm: First convert the array into heap data structure using heapify, then one by one
     * delete the root node of the max-heap and replace it with the last node in the heap and then
     * heapify the root of the heap. Repeat this process until the size of heap is greater than 1.
     *
     * 1. Build a heap from the given input array
     * 2. Repeat the following steps until the heap contains only one element:
     *      a. Swap the root element of the heap (which is the largest element) with the last element
     *      of the heap.
     *      b. Remove the last element from the heap, which is not at the correct position.
     *      c. Heapify the remaining elements of the heap.
     * 3. The sorted array is obtained by reversing the order of the elements in the input array.
     *
     * TC: (n * log n)
     * SC: O(log n) due to recursive call stack but it can be O(1) for iterative solution
     *
     * @param arr
     * @param n
     */
    private static void heapSort(int[] arr, int n) {
        // build head (rearrange array)
        for(int i = (n - 2) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // one by one extract an element from heap
        for(int i = n - 1; i > 0; i--) {
            // move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[], n is the size of the heap
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger than the root
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // if right child is larger than the root
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // if largest is not root
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
