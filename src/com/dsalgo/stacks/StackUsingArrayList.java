package com.dsalgo.stacks;

import java.util.ArrayList;

public class StackUsingArrayList {
    ArrayList<Integer> arrayList;
    int capacity;

    StackUsingArrayList(int c) {
        capacity = c;
        arrayList = new ArrayList<>(capacity);
    }

    void push(int x) {
        if(arrayList.size() == capacity) {
            System.out.println("stack overflow");
            return;
        }
        arrayList.add(x);       // add the element at the end of the list
    }

    int pop() {
        if(arrayList.size() == 0) {
            System.out.println("stack underflow");
            return -1;
        }
        int element = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        return element;
    }

    int peek() {
        if(arrayList.size() == 0) {
            System.out.println("stack underflow");
            return -1;
        }
        return arrayList.get(arrayList.size() - 1);
    }

    boolean isEmpty() {
        return arrayList.isEmpty();
    }

    int size() {
        return arrayList.size();
    }

    public static void main(String[] args) {
        StackUsingArrayList stack = new StackUsingArrayList(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}
