package com.dsalgo.queues;

import java.util.Arrays;

public class StackUsingCircularQueue {
    int front, rear, size;
    int capacity;
    int[] arr;

    StackUsingCircularQueue(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        rear = capacity - 1;
        arr = new int[this.capacity];
        Arrays.fill(arr, -1);
    }

    boolean isFull() {
        return (size == capacity);
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void push(int x) {
        if(isFull()) {
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    int pop() {
        if(isEmpty()) {
            return -1;
        }

        int element = arr[front];
        arr[front] = -1;
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    int top() {
        if(isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    int getSize() {
        return size;
    }

    void printStack() {
        System.out.println(Arrays.toString(this.arr));
    }

    public static void main(String[] args) {
        StackUsingCircularQueue stack = new StackUsingCircularQueue(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack size " + stack.getSize());
        stack.printStack();
        System.out.println("Deleted item " + stack.pop());
        System.out.println("Stack size " + stack.getSize());
        stack.printStack();
    }
}
