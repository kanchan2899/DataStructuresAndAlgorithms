package com.dsalgo.stacks;

public class StackUsingArray {
    int arr[];
    int capacity;
    int top;

    StackUsingArray(int c) {
        capacity = c;
        top = -1;
        arr = new int[capacity];
    }

    void push(int x) {
        if(top == capacity - 1) {
            System.out.println("stack overflow");
            return;
        }
        top++;
        arr[top] = x;
    }

    int pop() {
        if(top == -1) {
            System.out.println("stack underflow");
            return -1;
        }
        int element = arr[top];
        top--;
        return element;
    }

    int size() {
        return top++;
    }

    int peek() {
        if(top == -1) {
            System.out.println("stack underflow");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return (top == -1);
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
    }
}
