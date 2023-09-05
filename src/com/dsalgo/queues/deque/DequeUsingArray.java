package com.dsalgo.queues.deque;

import java.util.Arrays;

public class DequeUsingArray {
    int size, capacity, front;
    int[] arr;

    DequeUsingArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
        front = 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void insertFront(int x) {
        if(isFull()) {
            return;
        }
        // for(int i = size - 1; i >= 0; i--) {
        //     arr[i + 1] = arr[i];
        // }
        front = (front + capacity - 1) % capacity;
        arr[front] = x;
        size++;
    }

    void deleteFront() {
        if(isEmpty())
            return;
        // for(int i = 0; i < size - 1; i++) {
        //     arr[i] = arr[i + 1];
        // }
        front = (front + 1) % capacity;
        size--;
    }

    void deleteRear() {
        if(isEmpty())
            return;
        size--;
    }

    int getRear() {
        if(isEmpty())
            return -1;
        return size - 1;
    }

    int getFront() {
        if(isEmpty())
            return -1;
        return (front + size - 1) % capacity;
    }

    void insertRear(int x) {
        if(isFull()) {
            return;
        }
        int new_rear = (front + size) % capacity;
        arr[new_rear] = x;
        // arr[size] = x;
        size++;
    }

    public static void main(String[] args) {
        DequeUsingArray deque = new DequeUsingArray(4);
        deque.insertFront(1);
        deque.insertRear(2);
        deque.insertRear(3);
        deque.deleteFront();
        deque.deleteRear();
        System.out.println(Arrays.toString(deque.arr));
    }
}
