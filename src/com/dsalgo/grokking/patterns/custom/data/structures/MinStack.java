package com.dsalgo.grokking.patterns.custom.data.structures;

import com.sun.tools.javac.Main;

// https://leetcode.com/problems/min-stack/submissions/1200952857/
class MainStack<T> {
    private int maxSize;
    private int top;
    private T[] array;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public MainStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        array = (T[]) new Object[maxSize];
        this.currentSize = 0;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public T top() {
        if(isEmpty()) {
            return null;
        }
        return array[top];
    }

    public void push(T value) {
        if(isFull()) {
            return;
        }
        array[++top] = value;
        currentSize++;
    }

    public T pop(){
        if(isEmpty()) {
            return null;
        }
        currentSize--;
        return array[top--];
    }

}
public class MinStack {
    int maxSize;
    static MainStack<Integer> mainStack;
    MainStack<Integer> minStack;

    public MinStack() {
        this.maxSize = 100;
        mainStack = new MainStack<>(maxSize);
        minStack = new MainStack<>(maxSize);
    }

    public int pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public void push(Integer value) {
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.top() < value) {
            minStack.push(minStack.pop());
        } else {
            minStack.push(value);
        }
    }

    public int minNumber() {
        return minStack.pop();
    }

    public static void main(String[] args) {
        int[] num = {9, 3, 1, 4, 2, 5};
        int[] operations = {1, 1, 0, 1, 0, 1};

        MinStack stack = new MinStack();

        for(int i = 0; i < num.length; i++) {
            if(operations[i] == 1) {
                stack.push(num[i]);
            } else {
                System.out.println(stack.pop());
            }
        }
    }

}
