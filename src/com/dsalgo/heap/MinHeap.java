package com.dsalgo.heap;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    void insert(int x) {
        if(size == capacity) {
            return;
        }
        size++;
        arr[size - 1] = x;
        for(int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {
            // swap arr[i] and arr[parent(i)] if arr[parent(i)] is greater than the current element
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            // update i to be parent's index
            i = parent(i);
        }
    }

    void minHeapify(int i) {
        int leftChildIndex = left(i);
        int rightChildIndex = right(i);

        int smallest = i;

        if(leftChildIndex < size && arr[leftChildIndex] < arr[i]) {
            smallest = leftChildIndex;
        }

        if(rightChildIndex < size && arr[rightChildIndex] < arr[i]) {
            smallest = rightChildIndex;
        }

        if(smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            minHeapify(smallest);
        }
    }

    int getMin() {
        if(size > 0) {
            return arr[0];
        }
        return -1;
    }

    int extractMin() {
        if(size == 0) {
            return -1;
        }

        if(size == 1) {
            size--;
            return arr[0];
        }

        // swap first element with the last element
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;

        size--;

        minHeapify(0);

        return arr[size];
    }

    void decreaseKey(int i, int x) {
        arr[i] = x;

        while (i != 0 && arr[(parent(i))] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;

            i = parent(i);
        }
    }

    void deleteKey(int i) {
        if(i >= size) {
            return;
        }

        arr[i] = Integer.MIN_VALUE;

        decreaseKey(i, Integer.MIN_VALUE);

        extractMin();
    }

    void buildHeap() {
        for(int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    void maxHeapify(int[] a, int i) {
        int largest = i, left = 2 * i  + 1, right = 2 * i + 2;

        if(left < a.length && a[left] > a[largest]) {
            largest = left;
        }

        if(right < a.length && a[right] > a[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;

            maxHeapify(a, largest);
        }
    }

    void buildMaxHeap(int[] a) {
        for(int i = (a.length - 2) / 2; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    void heapSort(int[] a) {
        buildMaxHeap(a);

        for(int i = a.length - 1; i >= 1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(a, i);
        }
    }
}
