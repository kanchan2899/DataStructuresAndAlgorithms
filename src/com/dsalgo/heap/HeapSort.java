package com.dsalgo.heap;

import java.util.Arrays;

public class HeapSort {

    public void buildHeap(int[] arr, int n) {
        for(int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private void maxHeapify(int[] arr, int n, int i) {
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, n, largest);
        }
    }

    public void heapSort(int[] arr) {
        int n = arr.length;

        buildHeap(arr, n);

        for(int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 15, 5, 6, 7, 10};

        HeapSort sort = new HeapSort();

        sort.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
